package GenericBoxОfInteger;


import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        Box<Integer> box = new Box<> ();

        for (int i = 0; i < n; i++) {
            int integer = Integer.parseInt (scanner.nextLine ());
            box.addElement (integer);
        }
        System.out.println (box);
    }
}
