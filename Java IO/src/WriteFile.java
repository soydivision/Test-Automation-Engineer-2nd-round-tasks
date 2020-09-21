import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class WriteFile {
    private String path;
    private boolean append_to_file = false;

    public WriteFile(String file_path) {
        path = file_path;
    }

    public WriteFile(String file_path, boolean append_to_file) {
        path = file_path;
        this.append_to_file = append_to_file;
    }

    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter printWriter = new PrintWriter(write);
        printWriter.printf("%s" + "%n", textLine);
        printWriter.close();
    }


}
