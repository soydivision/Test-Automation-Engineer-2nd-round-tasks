import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File directoryPath = new File("C:\\Users\\PC\\Desktop\\Misc");
        File[] contents = directoryPath.listFiles();
        if (directoryPath.isDirectory()) {
        } else if (directoryPath.isFile()) {
            System.out.println("Это файл");
        }
        System.out.println("├───");
        




        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isFile()) {
                System.out.println("Is file");
            } else if (contents[i].isDirectory()) {
                System.out.println("Is Directory");
            }
        }
    }

    public static void listTree() {
    }
}