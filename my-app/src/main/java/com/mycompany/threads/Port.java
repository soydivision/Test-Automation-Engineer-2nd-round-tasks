package com.mycompany.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Port {
    int numberOfDocks;
    int containerStorageCapacity = 1000;
    public static int containers;
    List<Ship> shipList;
    public static final int maxShips = 10;
    public static final int minShips = 0;
    private int shipCount;
    String name;

    public synchronized void addToStorage(int containersFromShip) {
        containers = containers + containersFromShip;
    }

    public void removeFromStorage(int containersToShip) {
        containers = containers - containersToShip;
    }

    public Port(String name) {
        this.name = name;
        shipList = new ArrayList<>();
    }

    public synchronized boolean add(Ship ship) {
        try {
            if (shipCount < maxShips) {
                notifyAll();
                shipList.add(ship);
                System.out.println("Port " + name + ": New ship has arrived, unique id:");
                System.out.println(ship.getId());
                System.out.println("Storage capacity: " + ship.getContainerLoadCapacity());
                System.out.println("Containers on ship: " + ship.getContainersOnShip());
                System.out.println();
                shipCount++;
                System.out.println("Number of ships in port " + name + " right now: " + shipCount);
                System.out.println();
            } else {
                System.out.println("Port is full");
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get() {
        try {
            if (shipCount > minShips) {
                Random random = new Random();
                Ship randomShip = shipList.get(random.nextInt(shipList.size()));
                shipCount--;
                System.out.println("Number of ships in port " + this.name + " right now: " + shipCount);
                shipList.remove(randomShip);
                System.out.println("Ship " + randomShip.getId() + " has left port " + this.name);
                System.out.println("Ship " + randomShip.getId() + " is now in: " + Thread.currentThread().getName());
                return randomShip;
            } else if (shipCount == minShips) {
                System.out.println("Port is empty");
                return null;
            }
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    //drop ship if port is full
}
