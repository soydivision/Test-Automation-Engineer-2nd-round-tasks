package com.mycompany.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        System.out.println("В папке " + getFolderName(listOfLines) + " " + countFoldersAndFiles(listOfLines)[0] + " папок," + " и " + countFoldersAndFiles(listOfLines)[1] + " файлов.");
    }

    public static String getFolderName(ArrayList listOfLines) {
        return listOfLines.get(0).toString();
    }

    public static int[] countFoldersAndFiles(ArrayList listOfLines) {
        int folderCount = 0;
        int fileCount = 0;
        for (int i = 1; i < listOfLines.size(); i++) {
            String stringToCheck = listOfLines.get(i).toString();
            if (stringToCheck.contains("├")) {
                folderCount++;
            } else if (stringToCheck.contains("└")) {
                folderCount++;
            } else {
                fileCount++;
            }
        }
        int[] folderAndFileCounts = {folderCount, fileCount};
        return folderAndFileCounts;
    }
}
