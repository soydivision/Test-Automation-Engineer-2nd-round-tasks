import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        //Решить вопрос если будет файл а не папка
        //Если папка то надо сделать что бы сразу создавался файл txt с названием папки вверху
        File file = new File("C:\\Users\\PC\\Desktop\\Music");
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }
}

