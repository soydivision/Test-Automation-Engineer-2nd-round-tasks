package maintask;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String args[]) throws IOException {
        // File file = new File("C:\\Users\\PC\\Desktop\\Torrent");
        // File file = new File("C:\\Users\\PC\\Desktop\\Torrent\\outputFileWithSticks.txt");
        // File file = new File("C:\\Users\\PC\\Desktop\\Misc");
        File file = new File("C:\\Users\\PC\\Desktop\\Torrent\\outputFileWithSticks.txt");
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }
}

