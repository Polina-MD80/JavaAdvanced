import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class FixEmails {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String,String> emailsList = new LinkedHashMap<> ();

        String input = scanner.nextLine ();

        while (!"stop".equals (input)){
            String email = scanner.nextLine ();
            if (!(email.contains (".us")||email.contains (".uk")||email.contains (".com"))){
                emailsList.put (input,email);
            }

            input = scanner.nextLine ();
        }
        emailsList.forEach ((k,v)-> System.out.println (k + " -> " + v));
    }
}
