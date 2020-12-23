import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class Phonebook {
    public static
    void main (String[] args) {
        Scanner             scanner   = new Scanner (System.in);
        Pattern             pattern   = Pattern.compile ("(?<name>[A-z()]+)[-](?<number>[\\W\\d]+)");
        Map<String, String> phonebook = new HashMap<> ();

        String input = scanner.nextLine ();

        while (!"search".equals (input)) {
            Matcher matcher = pattern.matcher (input);
            if (matcher.find ()) {
                phonebook.put (matcher.group ("name"), matcher.group ("number"));
            }
            input = scanner.nextLine ();
        }
        input = scanner.nextLine ();
        while (!"stop".equals (input)) {
            if (phonebook.containsKey (input)) {
                System.out.println (input + " -> " + phonebook.get (input));
            } else System.out.println ("Contact " + input + " does not exist.");
            input = scanner.nextLine ();
        }
    }
}
