import java.util.Scanner;

public
class RecursiveFactorial {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        long n = Integer.parseInt (scanner.nextLine ());

        System.out.println (recursiveFactorial (n));
    }

    private static
    long recursiveFactorial (long n) {
        if (n==1){
            return 1;
        }
            return n * recursiveFactorial (n-1);
    }
}
