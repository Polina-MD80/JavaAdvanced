import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public
class AllCapitals {
    public static
    void main (String[] args) throws IOException {
        String                path   = "C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader reader =new BufferedReader (new FileReader (path));

        int oneByte = reader.read ();
        while (oneByte>0){
            System.out.print((Character.toUpperCase ((char) oneByte)));
            oneByte = reader.read ();
        }

    }
}
