package com.mycompany.threads.ShipTypes;

public enum Type {
    SMALLFEEDER(1000),
    FEEDER(2000),
    FEEDERMAX(3000),
    PANAMAX(4000),
    POSTPANAMAX(5000),
    NEWPANAMAX(10000),
    ULTRALARGE(14500);

    Type(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    private int loadCapacity;

    public int getLoadCapacity() {
        return loadCapacity;
    }
}
