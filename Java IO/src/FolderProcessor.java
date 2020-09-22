import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FolderProcessor {
    public static void listFilesTree(File directoryWithFiles, File parent) throws IOException {
        File outputFile = new File(parent.getPath() + File.separator + "filelist.txt");
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            String space = generateFourSpaces(howDeepIsYourPath(directoryWithFiles, parent));
            if (howDeepIsYourPath(directoryWithFiles, parent) == 0) {
                System.out.println(directoryWithFiles.getName());
                bufferedWriter.write(directoryWithFiles.getName() + System.lineSeparator());
            } else if (directoryWithFiles.isDirectory()) {
                System.out.println(space + "└───" + directoryWithFiles.getName());
                bufferedWriter.write(space + "└───" + directoryWithFiles.getName() + System.lineSeparator());
            }
            File[] content = directoryWithFiles.listFiles();
            ArrayList<File> folders = new ArrayList<>();
            for (int i = 0; i < content.length; i++) {
                if (content[i].isFile()) {
                    String spaceForFiles = generateFourSpaces(howDeepIsYourPath(content[i], parent));
                    System.out.println(spaceForFiles + "    " + content[i].getName());
                    bufferedWriter.write(spaceForFiles + "    " + content[i].getName() + System.lineSeparator());
                } else if (content[i].isDirectory()) {
                    folders.add(content[i]);
                }
            }
            for (int i = 0; i < folders.size(); i++) {
                listFilesTree(folders.get(i), parent);
            }
        }
    }

    public static void appendToTextFile() {

    }

    public static int howDeepIsYourPath(File parentDirectory, File childDirectory) {
        int depth;
        Path parentPath = Paths.get(parentDirectory.toURI());
        Path childPath = Paths.get(childDirectory.toURI());
        depth = parentPath.getNameCount() - childPath.getNameCount();
        return depth;
    }

    public static String generateFourSpaces(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("    ");
        }
        return stringBuilder.toString();
    }
}
