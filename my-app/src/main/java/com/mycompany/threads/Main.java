package com.mycompany.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//
        Port Arturchik = new Port("Arturchik");
        ShipGenerator generator = new ShipGenerator(Arturchik, 5);
        Dock dock1 = new Dock(Arturchik, "Dock one", 500, 200);
        Dock dock2 = new Dock(Arturchik, "Dock two", 200, 200);
        Dock dock3 = new Dock(Arturchik, "Dock three", 200, 200);
        Dock dock4 = new Dock(Arturchik, "Dock four", 200, 200);
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(generator);
        service.execute(dock1);
        service.execute(dock2);
        service.execute(dock3);
        service.execute(dock4);
        service.shutdown();
    }
}
