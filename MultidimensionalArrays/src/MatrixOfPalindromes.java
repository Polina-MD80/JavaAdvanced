import java.util.Scanner;

public
class MatrixOfPalindromes {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int rows = scanner.nextInt ();
        int cols = scanner.nextInt ();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String string = String.format ("%c%c%c",97+row,97+row+col,97+row);
                matrix[row][col] = string;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print (matrix[i][j]+" ");
            }
            System.out.println ();
        }
    }
}
