package com.masai.model;

import java.util.Random;

public enum Slots {
	slot1,
	slot2,
	slot3,
	slot4,
	slot5,
	slot6,
	slot7,
	slot8,
	slot9;

	public static Slots getRandomSlot() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
	public Boolean[] map = new Boolean[9];

	
}
