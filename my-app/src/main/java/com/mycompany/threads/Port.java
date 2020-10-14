package com.mycompany.threads;

import java.util.ArrayList;
import java.util.List;

public class Port {
    int numberOfDocks;
    int containerStorageCapacity;
    List<Ship> shipListinPort;
    public static final int maxShips = 30;
    public static final int minShips = 0;
    public int shipsInPort;
    String name;

    public Port() {
        shipListinPort = new ArrayList<>();
    }

    //    add ship
    public synchronized boolean addShip(Ship ship) {
        try {
            if (shipsInPort < maxShips) {
                notifyAll();
                shipListinPort.add(ship);
                String announcement = "Number of ships in port " + name + " right now: " + shipsInPort + ", New ship has arrived: " + ship.
            }
        } catch () {
        }
    }
    //get : get ship from port to dock
    //remove ship if port is full
}

