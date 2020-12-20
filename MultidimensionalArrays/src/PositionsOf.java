import java.util.Arrays;
import java.util.Scanner;

public
class PositionsOf {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = scanner.nextInt ();
        int coll = scanner.nextInt ();

        scanner.nextLine ();
        int[][] matrix =  new int[rows][coll];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
            matrix[i] = arr;
        }

        int n = Integer.parseInt (scanner.nextLine ());
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==n){
                    System.out.println (i +" "+ j);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println ("not found");
        }
    }
}
