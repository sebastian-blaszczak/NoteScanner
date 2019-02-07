import java.util.List;

public class Interpreter {

    private final List<String> linesOfFiles;
    private final String information;

    public Interpreter(List<String> linesOfFiles, String information) {
        this.linesOfFiles = linesOfFiles;
        this.information = information;
    }

    public String getInformation() {
        String result = "";
        for (String line : linesOfFiles) {
            if (line.contains(information)) {
                result += line;
            }
        }
        return result;
    }
}
