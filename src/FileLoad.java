import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileLoad {

    private final String path;

    private List<File> files = new ArrayList<>();

    public FileLoad(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    public List<File> loadFiles() {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    public List<String> readFiles() {
        if (files.size() == 0) {
            return Collections.emptyList();
        }

        List<String> filesToStrings = new ArrayList<>();
        for (File file : files) {
            String wholeFile = "";
            try {
                java.io.FileReader fileReader = new java.io.FileReader(file.getPath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";

                while ((line=bufferedReader.readLine()) != null){
                    wholeFile+=line+"\n";
                    if(line.equals("")){
                        filesToStrings.add(wholeFile);
                        wholeFile=new String();
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
