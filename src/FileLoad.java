import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class FileLoad {   // to utils classes better use final


    static List<File> loadFiles(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        List<File> files = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    static List<String> readFiles(List<File> files) {
        if (files.size() == 0) {
            return Collections.emptyList();
        }

        List<String> filesToStrings = new ArrayList<>();
        for (File file : files) {
            StringBuilder wholeFile = new StringBuilder();
            try {
                java.io.FileReader fileReader = new java.io.FileReader(file.getPath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    wholeFile.append(line).append("\n");
                    if (line.equals("")) {
                        filesToStrings.add(wholeFile.toString());
                        wholeFile = new StringBuilder();
                    }
                }

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                file.getPath() + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filesToStrings;
    }
}
