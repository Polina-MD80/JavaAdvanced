import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Crossfire {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = scanner.nextInt ();
        n = scanner.nextInt ();
        scanner.nextLine ();
        int[][] matrix = getMatrix (n);
        String  input;
        while (!"Nuke it from orbit".equals (input = scanner.nextLine ())) {
            String[] tokens     = input.split ("\\s+");
            int      bombRow    = Integer.parseInt (tokens[0]);
            int      bombCol    = Integer.parseInt (tokens[1]);
            int      bombRadius = Integer.parseInt (tokens[2]);

            matrix = bombInAction (matrix, bombRow, bombCol, bombRadius);
        }

        printMatrix (matrix);
    }

    private static
    int[][] bombInAction (int[][] matrix, int bombRow, int bombCol, int bombRadius) {
//        if (!indexesAreValid(matrix,bombRow,bombCol)){
//            return matrix;
//        }

        int i = bombRow;
        for (int j = bombCol - bombRadius; j <= bombCol + bombRadius; j++) {
            if (indexesAreValid (matrix, i, j)) {
                matrix[i][j] = 0;
            }
        }

        int j = bombCol;
        for (i = bombRow - bombRadius; i <= bombRow + bombRadius; i++) {
            if (indexesAreValid (matrix, i, j)) {
                matrix[i][j] = 0;
            }
        }

        matrix = resizeMatrix (matrix);
        return matrix;
    }

    private static
    int[][] resizeMatrix (int[][] matrix) {
        List<List<Integer>> rows = new ArrayList<> ();
        for (int i = 0; i < matrix.length; i++) {
            rows.add (new ArrayList<> ());
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    rows.get (i).add (matrix[i][j]);
                }
            }
        }
        for (int i = rows.size ()-1; i >= 0 ; i--) {
            if (rows.get (i).isEmpty ()){
                rows.remove (i);
            }
        }
        if (rows.isEmpty ()){
            return new int[0][0];
        }

        int[][] resizedMatrix = new int[rows.size ()][];


        for (int i = 0; i < rows.size (); i++) {
            resizedMatrix[i] = new int[rows.get (i).size ()];
        }
        for (int i = 0; i < resizedMatrix.length; i++) {
            for (int j = 0; j < resizedMatrix[i].length; j++) {
                resizedMatrix[i][j] = rows.get (i).get (j);
            }
        }
        matrix = resizedMatrix;
        return matrix;
    }

    private static
    boolean indexesAreValid (int[][] matrix, int row, int col) {
        if (row < matrix.length && row >= 0 && col >= 0 && col < matrix[row].length) {
            return true;
        }
        return false;
    }

    private static
    int[][] getMatrix (int n) {
        int[][] matrix = new int[n][n];
        int     number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = number;
                number++;
            }
        }

        return matrix;
    }

    private static
    void printMatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {

                    System.out.print (matrix[i][j] + " ");
                }
            }
            System.out.println ();
        }
    }
}
