public class Dock implements Runnable {
    int loadSpeed;
    int unloadSpeed;
    private Port port;

    public Dock(Port port, int loadSpeed, int unloadSpeed) {
        this.port = port;
        this.loadSpeed = loadSpeed;
        this.unloadSpeed = unloadSpeed;
    }

    @Override
    public void run() {
    }
    //методы погрузка/разгрузка
}
