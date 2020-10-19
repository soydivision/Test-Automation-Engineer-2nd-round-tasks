package com.mycompany.threads;

public class Dock implements Runnable {
    int loadSpeed;
    int unloadSpeed;
    int currentShipContainers;
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
                int containersToUnload = ship.getContainersOnShip();
                if (ship != null) {
                    System.out.println("Containers to unload :" + containersToUnload);
                    while (containersToUnload > 0) {
                        Thread.sleep(100);
                        if (containersToUnload - unloadSpeed > 0) {
                            ship.unloadShip(unloadSpeed);
                            port.addToStorage(unloadSpeed);
                            containersToUnload -= unloadSpeed;
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Currently left on ship: " + containersToUnload);
                            System.out.println();
                            System.out.println("Containers stored in port, total:" + port.containers);
                        } else if (containersToUnload == 0) {
                            System.out.println("Ship " + ship.getId() + " is fully unloaded");
                        } else if (containersToUnload != 0 && containersToUnload - unloadSpeed < 0) {
                            System.out.println("Small container number remains on ship" + ship.getId() + " : " + ship.getContainersOnShip());
                            System.out.println("Container to unload " + containersToUnload);
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            port.addToStorage(ship.getContainersOnShip());
                            containersToUnload = containersToUnload - ship.getContainersOnShip();
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
