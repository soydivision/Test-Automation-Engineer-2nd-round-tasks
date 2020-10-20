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
                if (ship != null) {
                    boolean shipUnloading = !ship.shipUnloaded;
                    int containersToUnload = ship.getContainersOnShip();
                    //Unloader part
                    while (shipUnloading) {
                        Thread.sleep(100);
                        if (containersToUnload == 0) {
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " Ship " + ship.getId() + " is unloaded");
                            shipUnloading = false;
                            ship.setShipUnloadedBoolean(true);
                        } else if (containersToUnload - unloadSpeed >= 0) {
                            ship.unloadShip(unloadSpeed);
                            port.addToStorage(unloadSpeed);
                            containersToUnload -= unloadSpeed;
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Currently,containers left on ship: " + containersToUnload);
                            System.out.println();
                        } else if (containersToUnload != 0 && containersToUnload - unloadSpeed < 0) {
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Last containers left on ship: " + ship.getId() + " : " + ship.getContainersOnShip());
                            System.out.println("Containers to unload " + containersToUnload);
                            System.out.println("'" + Thread.currentThread().getName() + "'" + " is reporting, unloading ship: " + ship.getId());
                            port.addToStorage(ship.getContainersOnShip());
                            containersToUnload = containersToUnload - ship.getContainersOnShip();
                            ship.unloadShip(ship.getContainersOnShip());
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Containers left on ship " + ship.getId() + " finally: " + ship.getContainersOnShip());
                            System.out.println();
                            System.out.println("Containers stored in port,  total: " + port.containers);
                        }
                    }
                    //Loader part
                    while (ship.ShipUnloaded() && !ship.ShipLoaded()) {
                        Thread.sleep(100);
                        if (port.containers == 0) {
                            System.out.println("'" + Thread.currentThread().getName() + "': " + "Port containers storage is empty");
                            ship.setShipLoadedBoolean(true);
                            ship = null;
                        } else if (ship.ShipLoaded()) {
                            System.out.println("'" + Thread.currentThread().getName() + "': " + "Ship " + ship.getId() + " has been unloaded and loaded, left port");
                            ship = null;
                        } else {
                            int containersToLoad = ship.getContainerLoadCapacity();
                            System.out.println("'" + Thread.currentThread().getName() + "': " + "Containers on ship " + ship.getId() + ": " + ship.getContainersOnShip());
                            System.out.println("'" + Thread.currentThread().getName() + "': " + "Containers to Load on ship " + ship.getId() + ": " + containersToLoad);
                            if (ship.getContainersOnShip() == ship.getContainerLoadCapacity()) {
                                System.out.println("'" + Thread.currentThread().getName() + "': " + "Ship fully loaded");
                                System.out.println("'" + Thread.currentThread().getName() + "': " + "containers left in port storage: " + port.containers);
                                ship.setShipLoadedBoolean(true);
                            } else if (ship.getContainersOnShip() + loadSpeed <= ship.getContainerLoadCapacity()) {
                                System.out.println("'" + Thread.currentThread().getName() + "': " + "Loading ship from dock " + ship.getId());
                                ship.loadShip(loadSpeed);
                                port.removeFromStorage(loadSpeed);
                            } else if (ship.getContainersOnShip() + loadSpeed > ship.getContainerLoadCapacity()) {
                                System.out.println("'" + Thread.currentThread().getName() + "': " + "Loading last containers on ship from dock " + ship.getId());
                                ship.loadShip(ship.getContainerLoadCapacity() - ship.getContainersOnShip());
                                port.removeFromStorage(ship.getContainerLoadCapacity() - ship.getContainersOnShip());
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
