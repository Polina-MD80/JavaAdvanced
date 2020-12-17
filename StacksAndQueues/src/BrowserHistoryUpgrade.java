import java.util.ArrayDeque;
import java.util.Scanner;

public
class BrowserHistoryUpgrade {
    public static
    void main (String[] args) {
        Scanner scanner    = new Scanner (System.in);
        String  navigation = scanner.nextLine ();

        ArrayDeque<String> stack = new ArrayDeque<> ();
        ArrayDeque<String> queue = new ArrayDeque<> ();

        String currant = "";

        while (!"Home".equals (navigation)) {
            if (navigation.equals ("back")) {
                if (!currant.equals ("")) {
                    queue.offer (currant);
                }
                if (stack.isEmpty ()) {
                    System.out.println ("no previous URLs");
                } else {
                    currant = stack.pop ();
                }

            } else if (navigation.equals ("forward")) {
                if (queue.isEmpty ()) {
                    System.out.println ("no next URLs");
                } else {
                    currant = queue.poll ();
                    stack.push (currant);
                }


            } else {
                stack.push (currant);
                currant = navigation;
                queue.clear ();

            }
            if (!currant.equals ("")) {
                System.out.println (currant);
            }
            navigation = scanner.nextLine ();
        }
    }
}
