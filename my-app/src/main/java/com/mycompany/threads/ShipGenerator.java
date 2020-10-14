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
            port.add(new Ship(500, 257));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    private Size getRandomSize() {
//        Size randomShipSize = Size.getRandomShipSize();
//        return randomShipSize.getLoadCapacity();
//    }
//    private Size getRandomContainersOnBoard() {
//        Random random = new Random();
//    }
}
