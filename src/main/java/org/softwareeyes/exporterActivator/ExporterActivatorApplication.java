package org.softwareeyes.exporterActivator;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExporterActivatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExporterActivatorApplication.class, args);
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("Exporter Activator")
                        .description("The exporter activator oversees the existing and new monitors (exporters)")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Exporter Activator Documentation")
                        .url("https://app.clickup.com/36882935/v/dc/135jfq-482")
                );
    }

}
