package com.mycompany.threads;

import java.util.UUID;

public class Ship {
    private static int count;
    int containerLoadCapacity;
    int containersOnShip;
    String name;
    String shipID;

    public Ship(int containerLoadCapacity, int containersOnShip) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        if (containersOnShip < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        this.containersOnShip = containersOnShip;
        shipID = UUID.randomUUID().toString();
        count++;
    }

    public Ship(int containerLoadCapacity, int containersOnShip, String name) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        if (containersOnShip < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        this.name = name;
        this.containersOnShip = containersOnShip;
        count++;
    }

    public int getShipCount() {
        return count;
    }
}

