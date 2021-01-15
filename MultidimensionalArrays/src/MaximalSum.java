import java.util.Arrays;
import java.util.Scanner;

public
class MaximalSum {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+"))
              .mapToInt (Integer::parseInt).toArray ();
        int rows = dimensions[0];
        int cols = dimensions[1];
        if (rows<3||cols<3){
            return;
        }
        
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();
            
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];

        for (int row = 0; row < rows-2; row++) {
            for (int col = 0; col < cols-2; col++) {
                int[][] currantMatrix = new int[3][3];
                int currantSum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        currantMatrix[k][l] = matrix[k+row][l+col];
                        currantSum += currantMatrix[k][l];
                    }
                }if (currantSum>maxSum){
                    maxSum = currantSum;
                    bestMatrix = currantMatrix;
                }
            }
        }
        System.out.println ("Sum = " +maxSum);
        for (int k = 0; k < bestMatrix.length; k++) {
            for (int l = 0; l < bestMatrix[0].length; l++) {
                System.out.print (bestMatrix[k][l]+" ");
            }
            System.out.println ();
        }
    }
}
