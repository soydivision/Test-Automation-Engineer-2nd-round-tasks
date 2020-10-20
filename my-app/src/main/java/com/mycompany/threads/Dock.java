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
                    //Unloader part
                    boolean shipUnloading = !ship.shipUnloaded;
                    int containersToUnload = ship.getContainersOnShip();
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
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Containers stored in port,  total: " + port.containers);
                        }
                    }
                    //Loader part
                    while (ship.ShipUnloaded() && !ship.ShipLoaded()) {
                        int shipFreeContainerSpace = ship.getContainerLoadCapacity() - ship.getContainersOnShip();
                        int portStock = port.getPortContainers();
                        if (portStock == 0) {
                            System.out.println("'" + Thread.currentThread().getName() + "':" + "Stock is empty");
                            System.out.println("Ship left: " + ship.getId() + " with " + ship.getContainersOnShip() + " containers");
                            ship.setShipLoadedBoolean(true);
                        } else if (shipFreeContainerSpace == 0) {
                            System.out.println("Ship left: " + ship.getId() + " with " + ship.getContainersOnShip() + " containers");
                            ship.setShipLoadedBoolean(true);
                        } else if (portStock > loadSpeed && loadSpeed > shipFreeContainerSpace) {
                            ship.loadShip(shipFreeContainerSpace);
                            port.removeFromStorage(shipFreeContainerSpace);
                            System.out.println("1'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + shipFreeContainerSpace + " containers");
                            ship.setShipLoadedBoolean(true);//ship = null;
                        } else if (portStock > loadSpeed && portStock < shipFreeContainerSpace) {
                            ship.loadShip(loadSpeed);
                            port.removeFromStorage(loadSpeed);
                            System.out.println("2'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + loadSpeed + " containers");
                        } else if (portStock > loadSpeed && loadSpeed <= shipFreeContainerSpace) {
                            ship.loadShip(loadSpeed);
                            port.removeFromStorage(loadSpeed);
                            System.out.println("3'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + loadSpeed + " containers");
                        } else if (portStock > shipFreeContainerSpace && loadSpeed > shipFreeContainerSpace) {
                            ship.loadShip(shipFreeContainerSpace);
                            port.removeFromStorage(shipFreeContainerSpace);
                            System.out.println("4'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + shipFreeContainerSpace + " containers");
                            ship.setShipLoadedBoolean(true);//ship = null;
                        } else if (portStock < loadSpeed && loadSpeed > shipFreeContainerSpace) {
                            ship.loadShip(portStock);
                            System.out.println("5'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + port.containers + " containers");
                            port.removeFromStorage(portStock);
                            ship.setShipLoadedBoolean(true);//ship = null;
                        } else if (portStock < loadSpeed && loadSpeed <= shipFreeContainerSpace) {
                            ship.loadShip(portStock);
                            System.out.println("6'" + Thread.currentThread().getName() + "':" + "Ship " + ship.getId() + " has loaded " + port.containers + " containers");
                            port.removeFromStorage(portStock);
                           // ship.setShipLoadedBoolean(true);//ship = null;
                        }
                    }
                }
            } catch (InterruptedException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
