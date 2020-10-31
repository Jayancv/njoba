package com.portal.operationUtils.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Availability result structure
 */
public class AdTypeResult implements Serializable {

    private long adTypeId;
    private String adTypeCode;

    Map<Long, ProductTypeResult> productTypeResults;

    public AdTypeResult(long adTypeId, String adTypeCode) {
        this.adTypeId = adTypeId;
        this.adTypeCode = adTypeCode;
    }

    public long getAdTypeId() {
        return adTypeId;
    }

    public void setAdTypeId(long adTypeId) {
        this.adTypeId = adTypeId;
    }

    public String getAdTypeCode() {
        return adTypeCode;
    }

    public void setAdTypeCode(String adTypeCode) {
        this.adTypeCode = adTypeCode;
    }

    public Map<Long, ProductTypeResult> getProductTypeResults() {
        if (productTypeResults == null) {
            productTypeResults = new HashMap<>();
        }
        return productTypeResults;
    }

    public void setProductTypeResults(Map<Long, ProductTypeResult> productTypeResults) {
        this.productTypeResults = productTypeResults;
    }
}
