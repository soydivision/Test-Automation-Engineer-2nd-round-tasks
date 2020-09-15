import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path");
        String string = scanner.nextLine();
        System.out.println(string);
        File directory = new File(string);
        if (directory.exists() && directory.isDirectory()) {
            for (File current : directory.listFiles()) {
                System.out.println(current.getPath());
            }
        }
    }
}
