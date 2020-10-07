package maintask;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        //File file = new File("C:\\Users\\PC\\Desktop\\Music");
        File file = new File(System.getProperty("user.dir") + File.separator + "outputFileWithSticks.txt");
        System.out.println(file.getPath());
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }
}

