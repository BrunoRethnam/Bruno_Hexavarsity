package com.asset.model;

public class Asset {
    private String assetId;
    private String name;
    private String type;
    private String serialNumber;
    private String purchaseDate;
    private String location;

    public Asset(String assetId, String name, String type, String serialNumber, String purchaseDate, String location) {
        this.assetId = assetId;
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.location = location;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
