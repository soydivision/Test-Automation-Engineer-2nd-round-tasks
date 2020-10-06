public class ShipGenerator implements Runnable {
    private Port port;
    int shipCount;

    public ShipGenerator(Port port, int shipCount) {
        this.port = port;
        this.shipCount = shipCount;
    }


    @Override
    public void run() {

    }

    //private Size getRandomSize()

}
