package org.softwareeyes.exporterActivator.admin.reload.models;

public class ForceReloadResponse {
    private boolean didReload;
    private int numberOfRestartedExporters;

    public ForceReloadResponse(boolean didReload, int numberOfRestartedExporters) {
        this.didReload = didReload;
        this.numberOfRestartedExporters = numberOfRestartedExporters;
    }

    public boolean isDidReload() {
        return didReload;
    }

    public int getNumberOfRestartedExporters() {
        return numberOfRestartedExporters;
    }
}
