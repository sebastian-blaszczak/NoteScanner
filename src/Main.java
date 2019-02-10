import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to file scanner of SDA Notes!");

        List<File> files = FileLoad.loadFiles("/home/shaders/SDA_Learning/Java/JavaNotes");
        List<String> fileToString = FileLoad.readFiles(files);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Implemented topics -> book news intellij goodPractice interview");
        System.out.println("Please provide topic:");

        String input = scanner.next();

        System.out.println(Interpreter.getInformation(input,fileToString));
    }
}
