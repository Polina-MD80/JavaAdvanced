import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public
class CopyAPicture {
    public static
    void main (String[] args) throws IOException {
        FileInputStream pic = new FileInputStream ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\JavaAdvanced\\softuni-2.0.jpg");
        FileOutputStream copy = new FileOutputStream ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\JavaAdvanced\\softuni-2.1.jpg");
        int oneByte = pic.read ();
        while (oneByte!= -1){
            copy.write (oneByte);
            oneByte = pic.read ();
        }
    }
}
