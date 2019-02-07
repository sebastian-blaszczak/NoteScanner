import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileLoad fileLoad = new FileLoad("/home/shaders/SDA_Learning/Java/JavaNotes");

        List<File> files = fileLoad.loadFiles();

        List<String> fileToString = fileLoad.readFiles();

        Interpreter interpreter = new Interpreter(fileToString,"goodPractice");

        System.out.println(interpreter.getInformation());
    }
}
