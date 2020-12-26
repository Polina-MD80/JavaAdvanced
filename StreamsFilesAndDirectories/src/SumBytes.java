import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public
class SumBytes {
    public static
    void main (String[] args) throws IOException {
        //Path path = Paths.get ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        String path = "C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader =new BufferedReader (new FileReader (path));
        long sum = 0;
        int oneByte = reader.read ();
        while (oneByte>0){
            sum += oneByte;
            oneByte = reader.read ();
        }
        System.out.println (sum);

    }
}
