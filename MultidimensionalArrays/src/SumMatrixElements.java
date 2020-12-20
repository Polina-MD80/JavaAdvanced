import java.util.Arrays;
import java.util.Scanner;

public
class SumMatrixElements {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String sizes = scanner.nextLine ();
        String splitter = ", ";
        int[][] matrix = readMatrix(sizes, scanner, splitter);
        System.out.println (matrix.length);
        System.out.println (matrix[0].length);
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println (sum);
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
