package maintask;

import java.io.*;

import java.util.ArrayList;

public class TextFileInputProcessor {
    public static void processTextFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufferedReader.readLine();
        }
        System.out.println("В папке " + getFolderName(listOfLines) + " " + countFolders(listOfLines) + " папок," + " и " + countFiles(listOfLines) + " файлов.");
    }

    public static String getFolderName(ArrayList listOfLines) {
        return listOfLines.get(0).toString();
    }

    public static int countFolders(ArrayList listOfLines) {
        int folderCount = 0;
        for (int i = 1; i < listOfLines.size(); i++) {
            char charCheck = listOfLines.get(i).toString().charAt(4);
            String stringToCheck = String.valueOf(charCheck);
            if (stringToCheck.equals("|")) {
                continue;
            } else if (stringToCheck.equals("├")) {
                folderCount++;
            } else if (stringToCheck.equals("└")) {
                folderCount++;
            }
        }
        return folderCount;
    }

    public static int countFiles(ArrayList listOfLines) {
        int filesCount = 0;
        for (int i = 1; i < listOfLines.size(); i++) {
            if (listOfLines.get(i).toString().contains("|")) {
                filesCount++;
            } else if (listOfLines.get(i).toString().contains("├") || listOfLines.get(i).toString().contains("└")) {
                break;
            }
        }
        return filesCount;
    }
}
