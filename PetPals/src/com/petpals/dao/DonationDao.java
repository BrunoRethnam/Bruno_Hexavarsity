package com.petpals.dao;

import com.petpals.model.*;
import java.util.*;

public class DonationDao {
    private static List<Donation> donations = new ArrayList<>();

    public void record(Donation donation) {
        donations.add(donation);
        donation.recordDonation();
    }
}