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
                    while (ship.getContainersOnShip() > 0) {
                        Thread.sleep(100);
                        if (ship.getContainersOnShip() - unloadSpeed > 0) {
                            ship.unloadShip(unloadSpeed);
                            port.addToStorage(unloadSpeed);
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Currently left on ship: " + ship.getContainersOnShip());
                            System.out.println();
                            System.out.println("Containers stored in port, total:" + port.containers);
                        } else {
                            System.out.println("Small container number remains on ship" + ship.getId() + " : " + ship.getContainersOnShip());
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            port.addToStorage(ship.getContainersOnShip());
                            ship.unloadShip(ship.getContainersOnShip());
                            System.out.println("Containers left on ship " + ship.getId() + " finally: " + ship.getContainersOnShip());
                            System.out.println("Containers stored in port,  total: " + port.containers);
                            System.out.println();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
