import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\TestFolder");
        System.out.println(file.getName());
        System.out.println(listFilesTree(file) + "\n");
        System.out.println();
    }

    public static StringBuilder listFilesTree(File directory) {
        StringBuilder stringBuilderTreeFiles = new StringBuilder();
        File[] content = directory.listFiles();
        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()) {
                stringBuilderTreeFiles.append("│" + generateFourSpaces(howDeepIsYourPath(directory, content[i])) + content[i].getName() + "\n");
            } else if (content[i].isDirectory()) {
                stringBuilderTreeFiles.append(listFilesTree(content[i]));
                System.out.print("└───");
                System.out.println(content[i].getName());
                System.out.println(listFilesTree(content[i]));
            }
        }
        return stringBuilderTreeFiles;
    }

    public static int howDeepIsYourPath(File parentDirectory, File childDirectory) {
        int depth;
        Path parentPath = Paths.get(parentDirectory.toURI());
        Path childPath = Paths.get(childDirectory.toURI());
        depth = childPath.getNameCount() - parentPath.getNameCount();
        return depth;
    }

    public static String generateFourSpaces(int length) {
        String shift = "   ";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(shift);
        }
        return stringBuilder.toString();
    }
}