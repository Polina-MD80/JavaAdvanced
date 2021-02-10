package Threeuple;

import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner  scanner   = new Scanner (System.in);

        String[] lineInput = scanner.nextLine ().split ("\\s+");
        String   name      = lineInput[0] + " " + lineInput[1];
        String   address   = lineInput[2];
        String   town      = lineInput[3];
        Threeuple<String,String,String> line1 = new Threeuple<String, String, String> (name,address,town);
        System.out.println (line1);

        String[] lineInput2 = scanner.nextLine ().split ("\\s+");
        name = lineInput2[0];
        int age = Integer.parseInt (lineInput2[1]);
        String drunkOrNot = lineInput2[2];

        Threeuple<String,Integer,String> line2 = new Threeuple<String, Integer, String> (name,age,drunkOrNot);
        line2.drunk (line2.getThird ());
        System.out.println (line2);

        String[] lineInput3 = scanner.nextLine ().split ("\\s+");
        name = lineInput3[0];
        double interest = Double.parseDouble (lineInput3[1]);
        String bank = lineInput3[2];
        Threeuple<String,Double,String> line3 = new Threeuple<String, Double, String> (name,interest,bank);
        System.out.println (line3);

    }
}
