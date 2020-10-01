package optionaltasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalTaskOne {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter destination path");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        File fileWithRandomNumbers = new File(path + File.separator + "fileWithRandomNumbers.txt");
        OutputStream outputStream = new FileOutputStream(fileWithRandomNumbers);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for (int i = 0; i < 10; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            bufferedWriter.write(randomNumber + System.lineSeparator());
        }
        bufferedWriter.close();
        sortNumberInFile(fileWithRandomNumbers);
    }

    public static void sortNumberInFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()));
        ArrayList<Integer> listOfLines = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            listOfLines.add(Integer.parseInt(line));
            line = bufferedReader.readLine();
        }
        Collections.sort(listOfLines);
        String path = file.getPath();
        String folderPath = path.substring(0, path.lastIndexOf(File.separator));
        File sortedFileWithRandomNumbers = new File(folderPath + File.separator + "sortedFileWithRandomNumbers.txt");
        OutputStream outputStream = new FileOutputStream(sortedFileWithRandomNumbers);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for (int i = 0; i < listOfLines.size(); i++) {
            bufferedWriter.write(listOfLines.get(i) + System.lineSeparator());
        }
        bufferedWriter.close();
    }
}
