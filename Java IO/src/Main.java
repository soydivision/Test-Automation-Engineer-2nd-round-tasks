import java.io.File;

public class Main {
    public static void main(String args[]) {
        File file = new File("C:\\Users\\PC\\Desktop\\Music");
        System.out.println(file.getName());
        File[] contents = directory.listFiles();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isFile()) {
                System.out.println("    " + contents[i].getName());
            } else if (contents[i].isDirectory()) {
                System.out.println("----" + contents[i].getName());
                listFilesTree(contents[i]);
            }
        }
    }

    public static void listFilesTree(File directory) {
        //Полный листинг файлов (для начала)
        //Попутно проверка наличия папок
        //При нахождении папок они отрисовывают (отдельный метод?)
        // в конце списка линии в parent директорию и вызывают листинг файлов
        //на себя
        File[] contents = directory.listFiles();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isFile()) {
                System.out.println("    " + contents[i].getName());
                //Добавить в стринг билдер
            } else if (contents[i].isDirectory()) {
//               Вызов метода который снова будет листить эту папку. И другой дорисует стрелки.
                System.out.println("----" + contents[i].getName());
                listFilesTree(contents[i]);
            }
        }
    }

    public static void listFilesAndFoldersTree(File directory) {
        //Полный листинг файлов (для начала)
        //Попутно проверка наличия папок
        //При нахождении папок они отрисовывают (отдельный метод?)
        // в конце списка линии в parent директорию и вызывают листинг файлов
        //на себя
        File[] contents = directory.listFiles();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isFile()) {
                System.out.println("    " + contents[i].getName());
                //Добавить в стринг билдер
            } else if (contents[i].isDirectory()) {
//               Вызов метода который снова будет листить эту папку. И другой дорисует стрелки.
                System.out.println("----" + contents[i].getName());
                listFilesTree(contents[i]);
            }
        }
    }

    public static void listFoldersTree(File directory) {
        //Полный листинг файлов (для начала)
        //Попутно проверка наличия папок
        //При нахождении папок они отрисовывают (отдельный метод?)
        // в конце списка линии в parent директорию и вызывают листинг файлов
        //на себя
        File[] contents = directory.listFiles();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i].isFile()) {
                System.out.println("    " + contents[i].getName());
                //Добавить в стринг билдер
            } else if (contents[i].isDirectory()) {
//               Вызов метода который снова будет листить эту папку. И другой дорисует стрелки.
                System.out.println("----" + contents[i].getName());
                listFilesTree(contents[i]);
            }
        }
    }
}