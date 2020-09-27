import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\test");
        FileInput fileInput = new FileInput();
        fileInput.readFile(file.getPath());
    }

    public static String replaceChar(String str, char ch, int index) {
        StringBuilder myString = new StringBuilder(str);
        myString.setCharAt(index, ch);
        return myString.toString();
    }
}

