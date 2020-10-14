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
                Thread.currentThread().setName(name);
                Thread.sleep(500);
                Ship ship = port.get();
                if (ship != null) {
                    while (ship.checkShipAvailableSpace()) {
                        Thread.sleep(100);
                        ship.loadShip(loadSpeed);
                        System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, loading ship: " + ship.getId());
                        System.out.println("'" + Thread.currentThread().getName() + "':"+"Currently loaded: " + ship.getContainersOnShip());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
