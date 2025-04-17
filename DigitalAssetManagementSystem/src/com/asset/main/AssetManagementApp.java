package com.asset.main;

import java.util.Scanner;

import com.asset.Dao.AssetManagementService;
import com.asset.Dao.AssetManagementServiceImpl;
import com.asset.exception.AssetNotFoundException;
import com.asset.exception.AssetNotMaintainException;
import com.asset.model.Asset;
import com.asset.model.Employee;

public class AssetManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetManagementService = new AssetManagementServiceImpl();
        
        // Main menu
        while (true) {
            System.out.println("\n===== Asset Management System =====");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Perform Maintenance");
            System.out.println("7. Reserve Asset");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Asset
                    System.out.print("Enter Asset ID: ");
                    String assetId = scanner.nextLine();
                    System.out.print("Enter Asset Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Asset Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Serial Number: ");
                    String serialNumber = scanner.nextLine();
                    System.out.print("Enter Purchase Date (yyyy-mm-dd): ");
                    String purchaseDate = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();

                    Asset newAsset = new Asset(assetId, name, type, serialNumber, purchaseDate, location);
                    boolean assetAdded = assetManagementService.addAsset(newAsset);
                    if (assetAdded) {
                        System.out.println("Asset added successfully.");
                    } else {
                        System.out.println("Failed to add asset.");
                    }
                    break;

                case 2:
                    // Update Asset
                    System.out.print("Enter Asset ID to update: ");
                    String updateAssetId = scanner.nextLine();
                    System.out.print("Enter new Asset Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Asset Type: ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter new Serial Number: ");
                    String newSerialNumber = scanner.nextLine();
                    System.out.print("Enter new Purchase Date (yyyy-mm-dd): ");
                    String newPurchaseDate = scanner.nextLine();
                    System.out.print("Enter new Location: ");
                    String newLocation = scanner.nextLine();

                    Asset updatedAsset = new Asset(updateAssetId, newName, newType, newSerialNumber, newPurchaseDate, newLocation);
                    boolean assetUpdated = assetManagementService.updateAsset(updatedAsset);
                    if (assetUpdated) {
                        System.out.println("Asset updated successfully.");
                    } else {
                        System.out.println("Failed to update asset.");
                    }
                    break;

                case 3:
                    // Delete Asset
                    System.out.print("Enter Asset ID to delete: ");
                    String deleteAssetId = scanner.nextLine();
                    boolean assetDeleted = assetManagementService.deleteAsset(deleteAssetId);
                    if (assetDeleted) {
                        System.out.println("Asset deleted successfully.");
                    } else {
                        System.out.println("Failed to delete asset.");
                    }
                    break;

                case 4:
                    // Allocate Asset
                    System.out.print("Enter Asset ID to allocate: ");
                    String allocateAssetId = scanner.nextLine();
                    System.out.print("Enter Employee ID to allocate to: ");
                    int employeeIdForAllocation = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Allocation Date (yyyy-mm-dd): ");
                    String allocationDate = scanner.nextLine();

                    boolean assetAllocated = assetManagementService.allocateAsset(allocateAssetId, employeeIdForAllocation, allocationDate);
                    if (assetAllocated) {
                        System.out.println("Asset allocated successfully.");
                    } else {
                        System.out.println("Failed to allocate asset.");
                    }
                    break;

                case 5:
                    // Deallocate Asset
                    System.out.print("Enter Asset ID to deallocate: ");
                    String deallocateAssetId = scanner.nextLine();
                    System.out.print("Enter Employee ID to deallocate from: ");
                    int employeeIdForDeallocation = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Return Date (yyyy-mm-dd): ");
                    String returnDate = scanner.nextLine();

                    boolean assetDeallocated = assetManagementService.deallocateAsset(deallocateAssetId, employeeIdForDeallocation, returnDate);
                    if (assetDeallocated) {
                        System.out.println("Asset deallocated successfully.");
                    } else {
                        System.out.println("Failed to deallocate asset.");
                    }
                    break;

                case 6:
                    // Perform Maintenance
                    System.out.print("Enter Asset ID for maintenance: ");
                    String maintenanceAssetId = scanner.nextLine();
                    System.out.print("Enter Maintenance Date (yyyy-mm-dd): ");
                    String maintenanceDate = scanner.nextLine();
                    System.out.print("Enter Description of Maintenance: ");
                    String maintenanceDescription = scanner.nextLine();
                    System.out.print("Enter Maintenance Cost: ");
                    double maintenanceCost = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    boolean maintenancePerformed = assetManagementService.performMaintenance(maintenanceAssetId, maintenanceDate, maintenanceDescription, maintenanceCost);
                    if (maintenancePerformed) {
                        System.out.println("Maintenance performed successfully.");
                    } else {
                        System.out.println("Failed to perform maintenance.");
                    }
                    break;

                case 7:
                    // Reserve Asset
                    System.out.print("Enter Asset ID to reserve: ");
                    String reserveAssetId = scanner.nextLine();
                    System.out.print("Enter Employee ID for reservation: ");
                    int employeeIdForReservation = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Reservation Date (yyyy-mm-dd): ");
                    String reservationDate = scanner.nextLine();
                    System.out.print("Enter Start Date (yyyy-mm-dd): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter End Date (yyyy-mm-dd): ");
                    String endDate = scanner.nextLine();

                    boolean assetReserved = assetManagementService.reserveAsset(reserveAssetId, employeeIdForReservation, reservationDate, startDate, endDate);
                    if (assetReserved) {
                        System.out.println("Asset reserved successfully.");
                    } else {
                        System.out.println("Failed to reserve asset.");
                    }
                    break;

                

                case 8:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

