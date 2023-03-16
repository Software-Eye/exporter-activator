package org.softwareeyes.exporterActivator.activator;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.softwareeyes.common.clients.SoftwareEyesMongoClient;
import org.softwareeyes.common.models.exporterConfiguration.ExporterConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    public ExporterActivator() {

    }

    @Scheduled(initialDelay = 1, fixedDelay = 5000)
    public void scanExporters() throws Exception {
        try (SoftwareEyesMongoClient exportersClient = new SoftwareEyesMongoClient(this.connectionString, this.databaseName, this.collectionName)) {
            MongoCollection<Document> collection = exportersClient.getQuerier();
            List<ExporterConfiguration> exporterConfigurations = collection.find(new Document(), ExporterConfiguration.class).into(new ArrayList<>());
            for (ExporterConfiguration configuration : exporterConfigurations) {
                activateExporter(configuration);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void clearExporters(){
        
    }

    private void activateExporter(ExporterConfiguration exporterConfiguration) {
        // TODO: implement exporter activation using terraform
    }
}
