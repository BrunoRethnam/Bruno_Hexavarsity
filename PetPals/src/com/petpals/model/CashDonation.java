package com.petpals.model;

import java.time.LocalDate;

public class CashDonation extends Donation {
    private LocalDate donationDate;

    public CashDonation(String donorName, double amount, LocalDate date) {
        super(donorName, amount);
        this.donationDate = date;
    }

    @Override
    public void recordDonation() {
        System.out.println("Cash Donation recorded on " + donationDate);
    }
}

