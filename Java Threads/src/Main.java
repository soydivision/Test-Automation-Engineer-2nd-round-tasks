public class Main {
    public static void main(String[] args) {
        Ship queenMary = new Ship(10, "Queen Mary");
        Ship axelMaersk = new Ship(5000, "Axel Maersk");

        System.out.println(axelMaersk.getShipCount());
    }
}
