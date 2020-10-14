package com.mycompany.threads;

public class Main {
    public static void main(String[] args) {
        Ship queenMary = new Ship(10, 3, "Queen Mary");
        Ship axelMaersk = new Ship(5000, 2600, "Axel Maersk");
        axelMaersk.getId();
        //Port.add ship
        System.out.println(axelMaersk.getShipCount());
    }
}
