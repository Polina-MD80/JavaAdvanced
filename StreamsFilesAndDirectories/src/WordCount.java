import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public
class WordCount {
    public static
    void main (String[] args) throws IOException {
        Path pathOfWords = Path.of ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path pathOfText  = Path.of ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        String wordsLine = Files.readString (pathOfWords);
        String[] words = wordsLine.split ("\\s+");
        List<String> lines = Files.readAllLines (pathOfText);

        Map<String, Integer> map = new LinkedHashMap<> ();
        for (String word : words) {
            map.put (word, 0);
        }

        for (int i = 0; i < lines.size (); i++) {
            String[] wordsInLine = lines.get (i).split ("\\s+");
            for (String word : wordsInLine) {
                if (map.containsKey (word)) {
                    map.put (word, map.get (word) + 1);
                }
            }
        }
        PrintWriter writer = new PrintWriter ("output.txt");

        map.forEach ((key, value) -> writer.println (key + " - " + value));
        writer.close ();
    }
}
