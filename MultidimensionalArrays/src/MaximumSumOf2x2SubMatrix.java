import java.util.Arrays;
import java.util.Scanner;

public
class MaximumSumOf2x2SubMatrix {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String sizes = scanner.nextLine ();
        String splitter = ", ";
        int[][] matrix = readMatrix(sizes, scanner, splitter);
        int[][] bestMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length-1; col++) {
                int el00 = matrix[row][col];
                int el01 = matrix[row][col+1];
                int el10 = matrix[row+1][col];
                int el11 = matrix[row+1][col+1];
                int currantSum = el00 + el01 +el10 + el11;

                if (currantSum>maxSum){
                    maxSum = currantSum;

                    bestMatrix = new int[][]{
                            {el00, el01},
                            {el10, el11}
                    };
                }
            }

        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print (bestMatrix[i][j]+" ");
            }
            System.out.println ();
        }
        System.out.println (maxSum);
    }

    private static
    int[][] readMatrix (String sizes, Scanner scanner, String splitter) {
        int rows = Integer.parseInt (sizes.split (splitter)[0]);
        int cols = Integer.parseInt (sizes.split (splitter)[1]);

        int[][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream (scanner.nextLine ().split (splitter)).mapToInt (Integer::parseInt).toArray ();
            matrix[row] = array;
        }
        return matrix;
    }
}
