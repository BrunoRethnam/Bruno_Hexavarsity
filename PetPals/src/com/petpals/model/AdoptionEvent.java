package com.petpals.model;



import com.petpals.dao.*;
import java.util.*;

public class AdoptionEvent {
    private List<IAdoptable> participants = new ArrayList<>();

    public void addParticipant(IAdoptable participant) {
        participants.add(participant);
    }

    public void hostEvent() {
        System.out.println("Adoption Event Participants:");
        for (IAdoptable p : participants) {
            p.adopt();
        }
    }
}


