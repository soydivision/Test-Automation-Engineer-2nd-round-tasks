import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FolderProcessor {
    public static void listFilesTree(File directoryWithFiles, File parent) throws IOException {
        String space = generateFourSpaces(howDeepIsYourPath(directoryWithFiles, parent));
        if (howDeepIsYourPath(directoryWithFiles, parent) == 0) {
            System.out.println(directoryWithFiles.getName());
        } else if (directoryWithFiles.isDirectory()) {
            System.out.println(space + "└───" + directoryWithFiles.getName());
        }
        File[] content = directoryWithFiles.listFiles();
        ArrayList<File> folders = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()) {
                String spaceForFiles = generateFourSpaces(howDeepIsYourPath(content[i], parent));
                System.out.println(spaceForFiles + "    " + content[i].getName());
            } else if (content[i].isDirectory()) {
                folders.add(content[i]);
            }
        }
        for (int i = 0; i < folders.size(); i++) {
            listFilesTree(folders.get(i), parent);
        }
    }

    public static int howDeepIsYourPath(File parentDirectory, File childDirectory) {
        int depth;
        Path parentPath = Paths.get(parentDirectory.toURI());
        Path childPath = Paths.get(childDirectory.toURI());
        depth = parentPath.getNameCount() - childPath.getNameCount();
        return depth;
    }

    public static String generateFourSpaces(int length) {
//        String shift;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("    ");
        }
        return stringBuilder.toString();
    }
}
