package com.portal.operationUtils;

public class ProductTypeResult {

    private long prodTypeId;
    private String prodTypeCode;
    private String prodTypeName;
    private int remainCount;
    private double price;

    public ProductTypeResult(long prodTypeId, String prodTypeCode, String prodTypeName, int remainCount, double price) {
        this.prodTypeId = prodTypeId;
        this.prodTypeCode = prodTypeCode;
        this.prodTypeName = prodTypeName;
        this.remainCount = remainCount;
        this.price = price;
    }

    public long getProdTypeId() {
        return prodTypeId;
    }

    public void setProdTypeId(long prodTypeId) {
        this.prodTypeId = prodTypeId;
    }

    public String getProdTypeCode() {
        return prodTypeCode;
    }

    public void setProdTypeCode(String prodTypeCode) {
        this.prodTypeCode = prodTypeCode;
    }

    public String getProdTypeName() {
        return prodTypeName;
    }

    public void setProdTypeName(String prodTypeName) {
        this.prodTypeName = prodTypeName;
    }

    public int getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(int remainCount) {
        this.remainCount = remainCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
