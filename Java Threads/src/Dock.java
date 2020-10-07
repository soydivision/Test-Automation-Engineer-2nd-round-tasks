import ShipTypes.Type;

public class Dock implements Runnable {
    int loadSpeed;
    int unloadSpeed;
    private Port port;
    String name;
    Type shipType;

    public Dock(Port port, String name, int loadSpeed, int unloadSpeed) {
        this.port = port;
        this.name = name;
        this.loadSpeed = loadSpeed;
        this.unloadSpeed = unloadSpeed;
    }

    @Override
    public void run() {
        //методы погрузка/разгрузка
    }
}
