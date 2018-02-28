package com.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataManager {

    /** Converts the file name to a parsable file.
     *
     * @param filename The name of the file desired to be used.
     * @return a String of the contents of the file.
     */
    public static String getFileContentsAsString(String filename) {
        final Path path = FileSystems.getDefault().getPath("data", filename);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println("Couldn't find file: " + filename);
            System.exit(-1);
            return null;
        }
    }
}
