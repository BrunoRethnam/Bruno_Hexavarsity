package com.asset.Dao;

import com.asset.model.Asset;

public interface AssetManagementService {
    boolean addAsset(Asset asset);
    boolean updateAsset(Asset asset);
    boolean deleteAsset(String assetId); // Changed to String
    boolean allocateAsset(String assetId, int employeeId, String allocationDate); // Changed assetId to String
    boolean deallocateAsset(String assetId, int employeeId, String returnDate); // Changed assetId to String
    boolean performMaintenance(String assetId, String maintenanceDate, String description, double cost); // Changed assetId to String
    boolean reserveAsset(String assetId, int employeeId, String reservationDate, String startDate, String endDate); // Changed assetId to String
}
