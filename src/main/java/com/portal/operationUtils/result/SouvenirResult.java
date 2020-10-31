package com.portal.operationUtils.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SouvenirResult implements Serializable {

    private long souvenirId;
    private String souvenirCode;
    private int souvenirYear;

    public SouvenirResult(long souvenirId, String souvenirCode, int souvenirYear) {
        this.souvenirId = souvenirId;
        this.souvenirCode = souvenirCode;
        this.souvenirYear = souvenirYear;
    }

    Map<Long, AdTypeResult> adTypeResults;

    public long getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(long souvenirId) {
        this.souvenirId = souvenirId;
    }

    public String getSouvenirCode() {
        return souvenirCode;
    }

    public void setSouvenirCode(String souvenirCode) {
        this.souvenirCode = souvenirCode;
    }

    public int getSouvenirYear() {
        return souvenirYear;
    }

    public void setSouvenirYear(int souvenirYear) {
        this.souvenirYear = souvenirYear;
    }

    public Map<Long, AdTypeResult> getAdTypeResults() {
        if (adTypeResults == null) {
            adTypeResults = new HashMap<>();
        }
        return adTypeResults;
    }

    public void setAdTypeResults(Map<Long, AdTypeResult> adTypeResults) {
        this.adTypeResults = adTypeResults;
    }
}
