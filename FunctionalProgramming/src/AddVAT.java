import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public
class AddVAT {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);
        UnaryOperator<Double> priseWithVAT = p -> p * 1.20;
        System.out.println ("Prices with VAT:");

        Arrays.stream (scanner.nextLine ().split (", "))
                .mapToDouble (Double::parseDouble)
                .map(priseWithVAT::apply)
                .forEach (p -> System.out.printf ("%.2f%n", p));

    }
}
