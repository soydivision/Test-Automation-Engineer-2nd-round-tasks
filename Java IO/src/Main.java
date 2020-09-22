import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\Python");
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }
}

