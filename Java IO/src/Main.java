import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\Misc");
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }
}

