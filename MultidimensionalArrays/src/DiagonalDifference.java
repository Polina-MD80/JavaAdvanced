import java.util.Arrays;
import java.util.Scanner;

public
class DiagonalDifference {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();
        }
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j){
                    firstSum += matrix[i][j];
                }
            }
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = n; j >=0; j--) {
                if (j == n-1 - i){
                    secondSum += matrix[i][j];
                }
            }
            
        }
        System.out.println (Math.abs (firstSum-secondSum));
    }
}
