
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public
class LineNumbers {
    public static
    void main (String[] args) throws IOException {


        Path path = Path.of ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines (path);

        PrintWriter writer = new PrintWriter ("output.txt");

        for (int i = 0; i < lines.size (); i++) {
            writer.println (i+1 + ". " + lines.get (i));
        }
        writer.close ();

    }
}
