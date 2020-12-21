import java.util.Arrays;
import java.util.Scanner;

public
class PrintDiagonalsOfSquareMatrix {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String sizes = scanner.nextLine ();
        String splitter = "\\s+";
        int[][] matrix = readMatrix(sizes, scanner, splitter);
        int row = 0;
        int col = 0;
        while (row<matrix.length){
            System.out.print (matrix[row][col]+" ");
            row++;
            col++;
        }
        System.out.println ();
        row = matrix.length-1;
        col =0 ;
        while (col < matrix.length){
            System.out.print (matrix[row][col]+" ");
            row--;
            col++;
        }
    }

    private static
    int[][] readMatrix (String sizes, Scanner scanner, String splitter) {
        int rows = Integer.parseInt (sizes.split (splitter)[0]);
        int cols = Integer.parseInt (sizes.split (splitter)[0]);

        int[][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = Arrays.stream (scanner.nextLine ().split (splitter)).mapToInt (Integer::parseInt).toArray ();
            matrix[row] = array;
        }
        return matrix;
    }
}
