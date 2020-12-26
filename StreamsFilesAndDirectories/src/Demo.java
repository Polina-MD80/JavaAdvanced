import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public
class Demo {
    public static
    void main (String[] args) throws IOException {
        String path = "C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream  fileInputStream = new FileInputStream (path);

        int nextByte = fileInputStream.read ();

        while (nextByte != -1){
            System.out.print (Character.toChars (nextByte));
            nextByte = fileInputStream.read ();
        }
    }
}
