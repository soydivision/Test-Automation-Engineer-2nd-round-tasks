import java.util.ArrayList;
import java.util.List;

public class Port {
    int numberOfDocks;
    int containerStorageCapacity;
    List<Ship> shipList;
    String name;

    public Port() {
        shipList = new ArrayList<>();
    }
}
