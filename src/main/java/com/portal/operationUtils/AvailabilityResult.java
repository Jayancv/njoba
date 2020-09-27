package com.portal.operationUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AvailabilityResult implements Serializable {

    private Map<Long, SouvenirResult> souvenirResults;

    public Map<Long, SouvenirResult> getSouvenirResults() {
        if (souvenirResults == null) {
            souvenirResults = new HashMap<>();
        }
        return souvenirResults;
    }

    public void setSouvenirResults(Map<Long, SouvenirResult> souvenirResults) {
        this.souvenirResults = souvenirResults;
    }
}
