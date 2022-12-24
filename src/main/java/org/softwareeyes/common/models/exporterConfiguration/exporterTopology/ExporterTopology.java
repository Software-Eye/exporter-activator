package org.softwareeyes.common.models.exporterConfiguration.exporterTopology;

public class ExporterTopology {
    private TopologyPosition position;
    private TopologyData Data;
    private String type;
    private String id;

    public ExporterTopology() {
    }

    public ExporterTopology(TopologyPosition position, TopologyData data, String type, String id) {
        this.position = position;
        Data = data;
        this.type = type;
        this.id = id;
    }

    public TopologyPosition getPosition() {
        return position;
    }

    public void setPosition(TopologyPosition position) {
        this.position = position;
    }

    public TopologyData getData() {
        return Data;
    }

    public void setData(TopologyData data) {
        Data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
