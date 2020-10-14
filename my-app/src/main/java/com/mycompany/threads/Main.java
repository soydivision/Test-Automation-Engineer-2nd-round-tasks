package com.mycompany.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Ship queenMary = new Ship(10, 3, "Queen Mary");
        Ship axelMaersk = new Ship(5000, 2600, "Axel Maersk");
        axelMaersk.getId();
        Port portArturchik = new Port();
        ShipGenerator generator = new ShipGenerator(portArturchik, 115);
        Dock dock1 = new Dock(portArturchik, "dock one", 50, 50);
        System.out.println(axelMaersk.getShipCount());
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(generator);
        service.execute(dock1);
        service.shutdown();
    }
}
