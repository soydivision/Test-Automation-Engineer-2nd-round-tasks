import java.io.*;
import java.util.ArrayList;

public class OutputFilePostProcessor {
    public static void addSomeSticks(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath() + File.separator + "filelist.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        File outputFileWithSticks = new File(file.getPath() + File.separator + "outputFileWithSticks.txt");
        OutputStream outputStream = new FileOutputStream(outputFileWithSticks);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(file.getName() + System.lineSeparator());
//
        String line = bufferedReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufferedReader.readLine();
        }
        for (int i = 0; i < listOfLines.size(); i++) {
            int lastPlace = 0;
//            System.out.println("Line iterated number: " + i + " ,is " + listOfLines.get(i));
            if (listOfLines.get(i).contains("└───")) {
//                System.out.println("Line contains └: " + listOfLines.get(i));
                int outputter = i - 1;
//                System.out.println("int j = i-1: " + outputter);
                for (int j = i - 1; j > lastPlace; j--) {
//                    System.out.println("Small for cycle, j is " + j);
                    if (listOfLines.get(j).length() > listOfLines.get(i).indexOf("└")) {
                        char charAtIndex = listOfLines.get(j).charAt(listOfLines.get(i).indexOf("└"));
//                        System.out.println("charAtIndex in .get(j) is:" + charAtIndex);
                        if (charAtIndex == ' ') {
                            String temp = replaceChar(listOfLines.get(j), '|', listOfLines.get(i).indexOf("└"));
//                            System.out.println("temp is: " + temp);
                            listOfLines.set(j, temp);
//                            System.out.println("Swap string is:" + listOfLines.get(j));
                        } else if (charAtIndex == '└') {
                            String temp = replaceChar(listOfLines.get(j), '├', listOfLines.get(i).indexOf("└"));
                            listOfLines.set(j, temp);
                        } else if (charAtIndex != ' ') {
                            break;
                        }
                    }
                }
//                System.out.println("lastplace is " + i);
                lastPlace = i;
            }
            bufferedReader.close();
        }
        for (int i = 0; i < listOfLines.size(); i++) {
            appendToTextFile(outputFileWithSticks, listOfLines.get(i) + System.lineSeparator());
        }
    }

    public static String replaceChar(String str, char ch, int index) {
        StringBuilder myString = new StringBuilder(str);
        myString.setCharAt(index, ch);
        return myString.toString();
    }

    public static void appendToTextFile(File filelist, String stringToAppend) throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(filelist, true));
        output.append(stringToAppend);
        output.close();
    }
}
