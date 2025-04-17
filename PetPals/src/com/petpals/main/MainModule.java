package com.petpals.main;



import com.petpals.dao.*;
import com.petpals.model.*;
import com.petpals.Util.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Connection connection = DBConnectUtil.getConnection();

        if (connection != null) {
            System.out.println("✅ Connection established successfully!");
        } else {
            System.out.println("❌ Failed to connect to the database.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        PetDao petDAO = new PetDao();
        DonationDao donationDAO = new DonationDao();
        AdoptionEventDao eventDAO = new AdoptionEventDao();

        while (true) {
            System.out.println("\n--- PetPals Menu ---");
            System.out.println("1. Add Pet");
            System.out.println("2. View Pets");
            System.out.println("3. Record Donation");
            System.out.println("4. Host Adoption Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter breed: ");
                    String breed = sc.nextLine();
                    petDAO.addPet(new Pet(name, age, breed));
                    break;

                case 2:
                    petDAO.getAllPets().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter donor name: ");
                    String donor = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Cash or Item (c/i): ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("c")) {
                        donationDAO.record(new CashDonation(donor, amt, LocalDate.now()));
                    } else {
                        System.out.print("Enter item type: ");
                        String item = sc.nextLine();
                        donationDAO.record(new ItemDonation(donor, amt, item));
                    }
                    break;

                case 4:
                    AdoptionEvent event = new AdoptionEvent();
                    for (Pet p : petDAO.getAllPets()) {
                        event.addParticipant(() -> System.out.println(p.getName() + " is ready for adoption."));
                    }
                    eventDAO.hostEvent(event);
                    break;

                case 5:
                    System.out.println("👋 Exiting PetPals. Thank you!");
                    return;

                default:
                    System.out.println("⚠ Invalid choice. Please try again.");
            }
        }
    }
}