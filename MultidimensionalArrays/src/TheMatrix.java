import java.util.Arrays;
import java.util.Scanner;

public
class TheMatrix {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);


        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int   row        = dimensions[0];
        int   col        = dimensions[1];


        char[][] matrix = new char[row][col];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine ().replace (" ", "").toCharArray ();
        }

        char  newChar              = scanner.nextLine ().charAt (0);
        int[] targetCarCoordinates = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int   targetRow            = targetCarCoordinates[0];
        int   targetCol            = targetCarCoordinates[1];
        char  targetChar           = matrix[targetRow][targetCol];

        refillTheMatrix (targetRow, targetCol, targetChar, newChar, matrix);

        printMatrix (matrix);
    }

    private static
    void printMatrix (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
    }

    private static
    void refillTheMatrix (int targetRow, int targetCol, char targetChar, char newChar, char[][] matrix) {
        if (!inBound (targetRow, targetCol, matrix) || matrix[targetRow][targetCol]!=targetChar ||
            matrix[targetRow][targetCol] == newChar) {
            return;
        } else {
            matrix[targetRow][targetCol] = newChar;
            refillTheMatrix (targetRow - 1, targetCol, targetChar, newChar, matrix);
            refillTheMatrix (targetRow + 1, targetCol, targetChar, newChar, matrix);
            refillTheMatrix (targetRow, targetCol - 1, targetChar, newChar, matrix);
            refillTheMatrix (targetRow, targetCol + 1, targetChar, newChar, matrix);
        }
    }

    private static
    boolean inBound (int targetRow, int targetCol, char[][] matrix) {
        return targetRow >= 0 && targetRow < matrix.length
               && targetCol >= 0 && targetCol < matrix[targetRow].length;
    }
}
