package org.softwareeyes.exporterActivator.activator;

import org.softwareeyes.common.models.exporterConfiguration.ExporterConfiguration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExporterActivator {

    @Scheduled(fixedDelay = 5000)
    public void scanExporters(){

    }

    private void activateExporter(ExporterConfiguration exporterConfiguration){

    }
}
