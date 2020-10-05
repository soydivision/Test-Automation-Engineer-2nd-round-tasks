public class Ship {
    private static int count;
    int containerLoadCapacity;
    String name;

    public Ship(int containerLoadCapacity) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        count++;
    }

    public Ship(int containerLoadCapacity, String name) throws ArithmeticException {
        if (containerLoadCapacity < 0) throw new ArithmeticException();
        this.containerLoadCapacity = containerLoadCapacity;
        this.name = name;
        count++;
    }

    public int getShipCount() {
        return count;
    }
}

