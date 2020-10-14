package com.mycompany.threads;

public class Dock implements Runnable {
    int loadSpeed;
    int unloadSpeed;
    private Port port;
    String name;

    public Dock(Port port, String name, int loadSpeed, int unloadSpeed) {
        this.port = port;
        this.name = name;
        this.loadSpeed = loadSpeed;
        this.unloadSpeed = unloadSpeed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName(name + " is loading ");
                Thread.sleep(500);
                Ship ship = port.get();
                if (ship != null) {
                    while (ship.checkShipAvailableSpace()) {
                        Thread.sleep(100);
                        ship.loadShip(10);
                        System.out.println("Loading ship:" + ship.getId() + ", by" + Thread.currentThread().getName());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
