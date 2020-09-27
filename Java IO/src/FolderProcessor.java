import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FolderProcessor {
    public static void listFilesTree(File directoryWithFiles, File parent) throws IOException {
        File outputFile = new File(parent.getPath() + File.separator + "filelist.txt");
        if (!outputFile.exists()) {
            OutputStream outputStream = new FileOutputStream(outputFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(parent.getName() + System.lineSeparator());
        }
        String space = generateFourSpaces(howDeepIsYourPath(directoryWithFiles, parent));
        if (howDeepIsYourPath(directoryWithFiles, parent) == 0) {
            appendToTextFile(outputFile, directoryWithFiles.getName() + System.lineSeparator());
        } else if (directoryWithFiles.isDirectory()) {
            appendToTextFile(outputFile, space + "└───" + directoryWithFiles.getName() + System.lineSeparator());
        }
        File[] content = directoryWithFiles.listFiles();
        ArrayList<File> folders = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()) {
                String spaceForFiles = generateFourSpaces(howDeepIsYourPath(content[i], parent));
                appendToTextFile(outputFile, spaceForFiles + "    " + content[i].getName() + System.lineSeparator());
            } else if (content[i].isDirectory()) {
                folders.add(content[i]);
            }
        }
        for (int i = 0; i < folders.size(); i++) {
            listFilesTree(folders.get(i), parent);
        }
    }

    public static void appendToTextFile(File filelist, String stringToAppend) throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(filelist, true));
        output.append(stringToAppend);
        output.close();
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
