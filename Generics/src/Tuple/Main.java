package Tuple;

import Threeuple.Threeuple;

import java.util.List;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner               scanner   = new Scanner (System.in);
        String[]              lineInput = scanner.nextLine ().split ("\\s+");
        String                name      = lineInput[0] + " " + lineInput[1];
        String                address   = lineInput[2];
        Tuple<String, String> line1     = new Tuple<String, String> (name, address);
        System.out.println (line1);

        String[]               lineInput2 = scanner.nextLine ().split ("\\s+");
        String                 az         = lineInput2[0];
        int                    integer    = Integer.parseInt (lineInput2[1]);
        Tuple<String, Integer> line2      = new Tuple<String, Integer> (az, integer);

        System.out.println (line2);

        String[]               lineInput3 = scanner.nextLine ().split ("\\s+");
        int                    numInteger = Integer.parseInt (lineInput3[0]);
        double                 numDouble  = Double.parseDouble (lineInput3[1]);
        Tuple<Integer, Double> line3      = new Tuple<Integer, Double> (numInteger, numDouble);
        System.out.println (line3);

    }
}
