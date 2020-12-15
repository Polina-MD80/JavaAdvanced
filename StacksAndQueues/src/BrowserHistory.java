import java.util.ArrayDeque;
import java.util.Scanner;

public
class BrowserHistory {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String navigation = scanner.nextLine ();

        ArrayDeque<String> history = new ArrayDeque<> ();

        String currant = "";

        while (!"Home".equals (navigation)){
            if (navigation.equals ("back")){
                if (history.isEmpty ()){
                    System.out.println ("no previous URLs");
                    navigation = scanner.nextLine ();
                    continue;
                }else {
                    currant = history.pop ();
                }

            }else {
               if (!currant.equals ("")){
                   history.push (currant);
               }
                currant = navigation;
            }
            System.out.println (currant);
            navigation = scanner.nextLine ();
        }
    }
}
