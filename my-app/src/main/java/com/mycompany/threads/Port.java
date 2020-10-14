package com.mycompany.threads;

import java.util.ArrayList;
import java.util.List;

public class Port {
    int numberOfDocks;
    int containerStorageCapacity = 1000;
    List<Ship> shipList;
    public static final int maxShips = 30;
    public static final int minShips = 0;
    private int shipCount;
    String name;

    public Port() {
        shipList = new ArrayList<>();
    }

    //    add ship
    public synchronized boolean add(Ship ship) {
        try {
            if (shipCount < maxShips) {
                notifyAll();
                shipList.add(ship);
                String announcement = "Number of ships in port " + name + " right now: " + shipCount + ", New ship has arrived: " + ship.getId())
                System.out.println(announcement);
                shipCount++;
            } else {
                System.out.println("Port is full");
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } return true;
    }

    //get : get ship from port to dock
    public synchronized Ship get(Ship ship) {
        try {
            if (shipCount > minShips) {
                for (Ship shipInPort : shipList) {
                    shipCount--;
                    System.out.println("Port has " + shipCount + " ships");
                    shipList.remove(shipInPort);
                    System.out.println("Ship " + shipInPort.getId() + " has left port");
                    System.out.println("Ship now is in: " + Thread.currentThread().getName());
                    return ship;
                }
                System.out.println("Port is empty");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
        //drop ship if port is full
    }
}
