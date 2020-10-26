package com.mycompany.threads.ShipSizes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Size {
    MICRO(100);
    //SMALLFEEDER(1000),
    // FEEDER(2000),
    // FEEDERMAX(3000),
    //PANAMAX(4000),
    //POSTPANAMAX(5000),
    //NEWPANAMAX(10000),
    //ULTRALARGE(14500);
    public int loadCapacity;

    Size(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    private static final List<Size> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Size getRandomShipSize() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}
