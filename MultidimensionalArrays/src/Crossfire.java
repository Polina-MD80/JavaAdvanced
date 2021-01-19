import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class Crossfire {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     rows    = scanner.nextInt ();
        int     cols    = scanner.nextInt ();
        scanner.nextLine ();

        List<List<Integer>> matrix = new ArrayList<> ();

        int count = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add (new ArrayList<> ());
            for (int col = 0; col < cols; col++) {
                matrix.get (row).add (count++);
            }
        }

        String input;
        while (!"Nuke it from orbit".equals (input = scanner.nextLine ())) {
            String[] tokens     = input.split ("\\s+");
            int      bombRow    = Integer.parseInt (tokens[0]);
            int      bombCol    = Integer.parseInt (tokens[1]);
            int      bombRadius = Integer.parseInt (tokens[2]);


            bombInAction (matrix, bombRow, bombCol, bombRadius);
        }

        if (!matrix.isEmpty ()) {
            printMatrix (matrix);
        }
    }

    private static
    void bombInAction (List<List<Integer>> matrix, int bombRow, int bombCol, int bombRadius) {


        for (int i = bombRow - bombRadius; i <= bombRow + bombRadius; i++) {
            if (indexesAreValid (matrix, i, bombCol)) {
                if (i != bombRow) {
                    matrix.get (i).remove (bombCol);
                }
            }
        }


        for (int j = bombCol+bombRadius; j >= bombCol - bombRadius ; j--) {
            if (indexesAreValid (matrix, bombRow, j)) {
                matrix.get (bombRow).remove (j);

            }
        }
        matrix.removeIf (List::isEmpty);
    }


    private static
    boolean indexesAreValid (List<List<Integer>> matrix, int row, int col) {
        return row < matrix.size () && row >= 0 && col >= 0 && col < matrix.get (row).size ();
    }


    private static
    void printMatrix (List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size (); i++) {
            for (int j = 0; j < matrix.get (i).size (); j++) {
                System.out.print (matrix.get (i).get (j) + " ");
            }
            System.out.println ();
        }
    }
}
