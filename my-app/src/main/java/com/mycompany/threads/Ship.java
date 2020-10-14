package com.mycompany.threads;

import java.util.UUID;

public class Ship {
    private static int shipCount;
    int containerLoadCapacity;
    int containersOnShip;
    String name;
    String id;


    public Ship(int containerLoadCapacity, int containersOnShip) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        if (containersOnShip < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        this.containersOnShip = containersOnShip;
        id = UUID.randomUUID().toString();
        shipCount++;
    }

    public Ship(int containerLoadCapacity, int containersOnShip, String name) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        if (containersOnShip < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        this.name = name;
        this.containersOnShip = containersOnShip;
        id = UUID.randomUUID().toString();
        shipCount++;
    }

    public int getShipCount() {
        return shipCount;
    }

    public boolean checkShipAvailableSpace() {
        if (containersOnShip > containerLoadCapacity) {
            return false;
        }
        return true;
    }

    public void loadShip(int containers) {
        this.containersOnShip += containers;
    }

    public void unloadShip(int containers) {
        this.containersOnShip -= containers;
    }

    public String getId() {
        return this.id;
    }
}

