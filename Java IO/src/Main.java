import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        File directoryPath = new File("C:\\Users\\PC\\Desktop\\Music");
        File[] contents = directoryPath.listFiles();
        if (directoryPath.isDirectory()) {
            StringBuilder stringBuilderFiles = new StringBuilder();
            StringBuilder stringBuilderFolders = new StringBuilder();
            stringBuilderFolders.append("├───" + directoryPath.getName() + "\n");
            for (int i = 0; i < contents.length; i++) {
                if (contents[i].isDirectory()) {
                    stringBuilderFolders.append("│   └───");
                    stringBuilderFolders.append(contents[i].getName() + "\n");
                    // и какой-нибудь листТриФолдер
                } else if (contents[i].isFile()) {
                    //Добавить файлы в строку какую-то.
                    stringBuilderFiles.append("│   " + contents[i].getName() + "\n");
                }
            }
            stringBuilderFolders.append(stringBuilderFiles);
            System.out.println(stringBuilderFolders);
        } else if (directoryPath.isFile()) {
            System.out.println("Это файл ");
//Если в качестве параметра в программу передается не путь к директории,
// а путь к txt файлу по образцу выше - прочитать файл и вывести в консоль следующие данные:
//    • Количество папок
//    • Количество файлов
//    • Среднее количество файлов в папке
//    • Среднюю длинну названия файла
        }
        System.out.println("TEST");
        StringBuilder test = listFilesTree(directoryPath);
        System.out.println(test);
    }

    public static StringBuilder listFilesTree(File directoryWithFiles) {
        StringBuilder stringBuilderTreeFiles = new StringBuilder();
        File[] content = directoryWithFiles.listFiles();
        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()) {
                //Добавить файлы в строку какую-то.
                stringBuilderTreeFiles.append("│   " + content[i].getName() + "\n");
            }
        }
        return stringBuilderTreeFiles;
    }
}