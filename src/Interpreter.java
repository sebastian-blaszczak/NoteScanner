import java.util.List;

class Interpreter {


    static String getInformation(String information, List<String> linesOfFiles) {
        String result = "";
        for (String line : linesOfFiles) {
            if (line.contains(information) && line.contains("Tags")) {
                continue;
            } else if (line.contains(information)) {
                result += line;
            }
        }
        return result;
    }
}
