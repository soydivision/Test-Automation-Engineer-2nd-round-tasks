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
        int foldersCount = 0;
        for (int i = 0; i < listOfLines.size(); i++) {
//            if (listOfLines.get(i).toString().contains("|") && !listOfLines.get(i).toString().contains("├")) {
//                continue;
//            } else if (listOfLines.get(i).toString().contains("├") && !listOfLines.get(i).toString().contains("|")) {
//                foldersCount++;
//                System.out.println("pass " + listOfLines.get(i));
//            } else if (listOfLines.get(i).toString().contains("└") && !listOfLines.get(i).toString().contains("|")) {
//                foldersCount++;
//                System.out.println("pass " + listOfLines.get(i));
//            }
            String stringToCheck = listOfLines.get(i).toString();
            System.out.println("stringToCheck size " +stringToCheck.length());
            char[] charArray = stringToCheck.toCharArray();
            String stringWithChar = Character.toString(charArray[4]);
            if (stringWithChar == "|" && stringWithChar != "├") {
                continue;
            } else if (stringWithChar == ("├") && stringWithChar != ("|")) {
                foldersCount++;
                System.out.println("pass " + listOfLines.get(i));
            } else if (stringWithChar == "└" && stringWithChar != ("|")) {
                foldersCount++;
                System.out.println("pass " + listOfLines.get(i));
            }
        }
        return foldersCount;
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
