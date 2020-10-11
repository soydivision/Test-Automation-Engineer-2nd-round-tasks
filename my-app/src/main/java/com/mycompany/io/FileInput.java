package com.mycompany.io;

import java.io.File;
import java.io.IOException;

public class FileInput {
    public void readFile(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            FolderProcessor folderProcessor = new FolderProcessor();
            folderProcessor.listFilesTree(file, file);
            OutputTextFilePostProcessor outputFilePostProcessor = new OutputTextFilePostProcessor();
            outputFilePostProcessor.addSomeSticks(file);
        } else if (file.isFile()) {
            TextFileInputProcessor textFileInputProcessor = new TextFileInputProcessor();
            textFileInputProcessor.processTextFile(file);
        }
    }
}

