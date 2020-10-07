package maintask;

import java.io.*;
import java.util.ArrayList;

public class OutputTextFilePostProcessor {
    public static void addSomeSticks(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "TemporaryFileList.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        File outputFileWithSticks = new File(System.getProperty("user.dir") + File.separator + "FileList.txt");
        OutputStream outputStream = new FileOutputStream(outputFileWithSticks);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(file.getName() + System.lineSeparator());
        File fileToRemove = new File(System.getProperty("user.dir") + File.separator + "TemporaryFileList.txt");
        String line = bufferedReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufferedReader.readLine();
        }
        for (int i = 0; i < listOfLines.size(); i++) {
            int lastPlace = 0;
            if (listOfLines.get(i).contains("└───")) {
                for (int j = i - 1; j > lastPlace; j--) {
                    if (listOfLines.get(j).length() > listOfLines.get(i).indexOf("└")) {
                        char charAtIndex = listOfLines.get(j).charAt(listOfLines.get(i).indexOf("└"));
                        if (charAtIndex == ' ') {
                            String temp = replaceChar(listOfLines.get(j), '|', listOfLines.get(i).indexOf("└"));
                            listOfLines.set(j, temp);
                        } else if (charAtIndex == '└') {
                            String temp = replaceChar(listOfLines.get(j), '├', listOfLines.get(i).indexOf("└"));
                            listOfLines.set(j, temp);
                        } else if (charAtIndex != ' ') {
                            break;
                        }
                    }
                }
                lastPlace = i;
            }
            bufferedReader.close();
        }
        for (int i = 0; i < listOfLines.size(); i++) {
            appendToTextFile(outputFileWithSticks, listOfLines.get(i) + System.lineSeparator());
        }
        fileToRemove.delete();
    }

    public static String replaceChar(String str, char ch, int index) {
        StringBuilder myString = new StringBuilder(str);
        myString.setCharAt(index, ch);
        return myString.toString();
    }

    public static void appendToTextFile(File fileTXT, String stringToAppend) throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(fileTXT, true));
        output.append(stringToAppend);
        output.close();
    }
}
