import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public
class SumLines {
    public static
    void main (String[] args) throws IOException {
        Path           inputPath = Paths.get ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        BufferedReader reader    = Files.newBufferedReader (inputPath);

        String line = reader.readLine ();
        while (line!=null){
            long sum = 0;
            char[] chars = line.toCharArray ();
            for (char c : chars) {
                sum += c;
            }
            System.out.println (sum);

            line = reader.readLine ();
        }
    }
}
