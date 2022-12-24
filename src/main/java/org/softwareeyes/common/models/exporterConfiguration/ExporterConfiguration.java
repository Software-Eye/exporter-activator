package org.softwareeyes.common.models.exporterConfiguration;

import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.ExporterTopology;

public class ExporterConfiguration {
    private ExporterMetadata metadata;
    private ExporterConfigurationParametersBase exporterConfiguration;
    private ExporterTopology topology;
    private String _id;

    public ExporterConfiguration() {
    }

    public ExporterConfiguration(ExporterMetadata metadata, ExporterConfigurationParametersBase exporterConfiguration, ExporterTopology topology, String id) {
        this.metadata = metadata;
        this.exporterConfiguration = exporterConfiguration;
        this.topology = topology;
        this._id = id;
    }

    public ExporterMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ExporterMetadata metadata) {
        this.metadata = metadata;
    }

    public ExporterConfigurationParametersBase getExporterConfiguration() {
        return exporterConfiguration;
    }

    public void setExporterConfiguration(ExporterConfigurationParametersBase exporterConfiguration) {
        this.exporterConfiguration = exporterConfiguration;
    }

    public ExporterTopology getTopology() {
        return topology;
    }

    public void setTopology(ExporterTopology topology) {
        this.topology = topology;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }
}
