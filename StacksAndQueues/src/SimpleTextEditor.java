import java.util.ArrayDeque;
import java.util.Scanner;

public
class SimpleTextEditor {
    public static
    void main (String[] args) {
        Scanner              scanner = new Scanner (System.in);
        String text = "";
        ArrayDeque<String[]> stack   = new ArrayDeque<> ();

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine ().split ("\\s+");

            switch (command[0]) {
                case "1":
                  text =  text.concat (command[1]);
                    stack.push (command);
                    break;
                case "2":
                    int count = Integer.parseInt (command[1]);
                    command[1] = text.substring (text.length () - count);
                    text = text.substring (0,text.length ()-count);
                    stack.push (command);
                    break;
                case "3":
                    int index = Integer.parseInt (command[1]);
                    System.out.println (text.charAt (index-1));
                    break;
                case "4":
                    if (!stack.isEmpty ()) {
                        String[] undoCommand = stack.pop ();
                        switch (undoCommand[0]){
                            case"1":
                                text = text.substring (0,text.length ()-undoCommand[1].length ());
                                break;
                            case"2":
                                text = text .concat ( undoCommand[1]);
                                break;
                        }
                            break;
                    }
            }
        }
    }
}
