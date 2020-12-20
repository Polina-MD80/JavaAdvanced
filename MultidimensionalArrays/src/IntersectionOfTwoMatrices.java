import java.util.Scanner;

public
class IntersectionOfTwoMatrices {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int rows = Integer.parseInt (scanner.nextLine ());
        int cols = Integer.parseInt (scanner.nextLine ());

        char[][] firstMatrix = createCharMatrix(scanner,rows,cols);
        char[][] secondMatrix = createCharMatrix (scanner,rows,cols);
        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int coll = 0; coll < cols; coll++) {
                resultMatrix[row][coll]= firstMatrix[row][coll]==secondMatrix[row][coll] ? firstMatrix[row][coll] : '*';
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int call = 0; call < cols; call++) {
                System.out.print (resultMatrix[row][call] + " ");
            }
            System.out.println ();
        }

    }

    private static
    char[][] createCharMatrix (Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine ().split (" ");
            for (int coll = 0; coll <cols ; coll++) {
                matrix[row][coll] = line[coll].charAt (0);
            }
        }
        return matrix;
    }
}
