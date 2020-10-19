package com.mycompany.threads;

import com.mycompany.threads.ShipSizes.*;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Port port;
    int shipsToGenerate;

    public ShipGenerator(Port port, int shipsToGenerate) {
        this.port = port;
        this.shipsToGenerate = shipsToGenerate;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipsToGenerate) {
            Thread.currentThread().setName("Ship generator");
            count++;
            Size randomSizeShipStorage = getRandomSizeShip();
            int containersOnBoard = getRandomContainersOnBoard(randomSizeShipStorage.getLoadCapacity());
            System.out.println(Thread.currentThread().getName() + " new ship generated, being added to port");
            port.add(new Ship(randomSizeShipStorage, containersOnBoard));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Size getRandomSizeShip() {
        Size.getRandomShipSize();
        return Size.getRandomShipSize();
    }

    private int getRandomContainersOnBoard(int maxNumberOfContainers) {
        Random random = new Random();
        int containersNumberOnBoard = random.nextInt(maxNumberOfContainers);
        return containersNumberOnBoard;
    }
}
