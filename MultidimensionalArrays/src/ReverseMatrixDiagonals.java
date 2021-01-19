import java.util.*;

public
class ReverseMatrixDiagonals {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt)
                .toArray ();

        int m = dimensions[0];
        int n = dimensions[1];

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i] = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                    .mapToInt (Integer::parseInt).toArray ();
        }
        List<List<Integer>> diagonals = new ArrayList<> ();
        for (int i = 0; i < m + n - 1; i++) {
            diagonals.add (new ArrayList<> ());
        }

        int col = 0;
        int row = matrix.length - 1;
        while (row >=0&& col < n) {
            for (int c = matrix[row].length - 1; c >= col; c--) {
                diagonals.get (row + c).add (matrix[row][c]);
            }

            row--;
            int c = col;
            for (int r = row ; r >= 0; r--) {
                diagonals.get (r + c).add (matrix[r][c]);
            }
            col++;
        }
         Collections.reverse (diagonals);

        for (List<Integer> l : diagonals) {
            for (Integer integer : l) {
                System.out.print (integer + " ");
            }
            System.out.println ();
        }
    }

}

