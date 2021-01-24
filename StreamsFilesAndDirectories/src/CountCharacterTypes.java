import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public
class CountCharacterTypes {
    public static
    void main (String[] args) throws IOException {

        Path path = Path.of ("C:\\Users\\Poli_ip\\Dropbox\\My PC (LAPTOP-F54G9BS7)\\Documents\\SoftUniJavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        byte[] bytes = Files.readAllBytes (path);

        PrintWriter writer = new PrintWriter ("output.txt");


        List<Character> vowelsSet = List.of ('a', 'e','i', 'o', 'u');
        List<Character> punctuations = List.of ('!', ',', '.', '?');

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        for (byte aByte : bytes) {
            if (aByte>=0&&aByte<=32){
                continue;
            }
            if (vowelsSet.contains ((char)aByte)){
                vowels ++;
            }else if (punctuations.contains ((char)aByte)){
                punctuation ++;
            }else {
                consonants ++;
            }

        }
        //
        //Consonants: 72
        //Punctuation: 6

        writer.println ("Vowels: " + vowels);
        writer.println ("Consonants: " + consonants);
        writer.println ("Punctuation: " + punctuation);

        writer.close ();


    }
}
