package com.mycompany.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Ship queenMary = new Ship(10, 3, "Queen Mary");
        Ship axelMaersk = new Ship(5000, 2600, "Axel Maersk");
        axelMaersk.getId();
        Port Arturchik = new Port("Arturchik");
        ShipGenerator generator = new ShipGenerator(Arturchik, 10);
        Dock dock1 = new Dock(Arturchik, "dock speedy one", 50, 50);
        Dock dock2 = new Dock(Arturchik, "Slow dock", 20, 50);
        System.out.println(axelMaersk.getShipCount());
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(generator);
        service.execute(dock1);
        service.execute(dock2);
        service.shutdown();
    }
}
