package org.softwareeyes.exporterActivator.activator;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.softwareeyes.common.clients.SoftwareEyesMongoClient;
import org.softwareeyes.common.models.exporterConfiguration.ExporterConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.*;
import software.amazon.awssdk.services.lambda.waiters.LambdaWaiter;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExporterActivator {
    @Value("${exporter.activator.connectionString}")
    private String connectionString;
    @Value("${exporter.activator.databaseName}")
    private String databaseName;
    @Value("${exporter.activator.collectionName}")
    private String collectionName;
    @Value("${exporter.activator.scopeName}")
    private String scopeName;

    private final LambdaClient lambdaClient;

    public ExporterActivator() {
        lambdaClient = LambdaClient.builder().credentialsProvider(EnvironmentVariableCredentialsProvider.create()).build();
    }

    @Scheduled(initialDelay = 1, fixedDelay = 5000)
    public void scanExporters() throws Exception {
        try (SoftwareEyesMongoClient exportersClient = new SoftwareEyesMongoClient(this.connectionString, this.databaseName)) {
            MongoCollection<Document> collection = exportersClient.getQuerier(this.collectionName);
            List<ExporterConfiguration> exporterConfigurations = collection.find(new Document(), ExporterConfiguration.class).into(new ArrayList<>());
            for (ExporterConfiguration configuration : exporterConfigurations) {
                activateExporter(configuration);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void clearExporters() {

    }

    private void activateExporter(ExporterConfiguration exporterConfiguration) {
        LambdaWaiter waiter = lambdaClient.waiter();
        CreateFunctionRequest functionRequest = exporterConfiguration.CreateLambdaFunction();
        String functionName = functionRequest.functionName();
        CreateFunctionUrlConfigRequest createFunctionUrlConfigRequest = CreateFunctionUrlConfigRequest.builder().functionName(functionName).authType(FunctionUrlAuthType.NONE).build();
        CreateFunctionResponse functionResponse = lambdaClient.createFunction(functionRequest);
        GetFunctionRequest getFunctionRequest = GetFunctionRequest.builder().functionName(functionName).build();
        waiter.waitUntilFunctionExists(getFunctionRequest);
        CreateFunctionUrlConfigResponse functionUrlResponse = lambdaClient.createFunctionUrlConfig(createFunctionUrlConfigRequest);
        System.out.println("The function URL is " + functionUrlResponse.functionUrl());
    }
}
