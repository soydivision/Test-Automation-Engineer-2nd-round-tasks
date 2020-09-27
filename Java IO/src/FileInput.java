import java.io.File;
import java.io.IOException;

public class FileInput {
    public void readFile(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            FolderProcessor folderProcessor = new FolderProcessor();
            folderProcessor.listFilesTree(file, file);
            OutputFilePostProcessor outputFilePostProcessor = new OutputFilePostProcessor();
            outputFilePostProcessor.addSomeSticks(file);
        } else {
            //Добавить проверку txt
            System.out.println("need file processor");
        }
    }
}

