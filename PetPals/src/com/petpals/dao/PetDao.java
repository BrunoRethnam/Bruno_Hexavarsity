package com.petpals.dao;

import com.petpals.model.*;
import java.util.*;

public class PetDao {
    private static List<Pet> petDB = new ArrayList<>();

    public void addPet(Pet pet) { petDB.add(pet); }
    public List<Pet> getAllPets() { return petDB; }
}