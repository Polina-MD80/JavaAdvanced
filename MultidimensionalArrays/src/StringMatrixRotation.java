import java.util.*;

public
class StringMatrixRotation {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String command = scanner.nextLine ();

        List<String> lines = new ArrayList<> ();

        String input;


        while (!"END".equals (input = scanner.nextLine ())) {
            lines.add (input);

        }

        String max = lines.stream ().max (Comparator.comparing (String::length)).map (Object::toString).orElseThrow ();

        int rows = lines.size ();
        int cols = max.length ();

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = lines.get (row).toCharArray ();
        }

        String degreesAsString = command.substring (7, command.length () - 1);

        int degrees = Integer.parseInt (degreesAsString);

        if (degrees % 360 == 0) {
            printMatrix (matrix);
        } else if (degrees % 360 == 270) {
            matrix270 (cols, rows, matrix);
        } else if (degrees % 360 == 90) {
            matrix90 (cols, rows, matrix);
        } else if (degrees % 360 == 180) {
            matrix180 (rows, cols, matrix);
        }


    }

    private static
    void matrix180 (int rows, int cols, char[][] matrix) {
        char[][] matrix180 = new char[rows][cols];
        int      i         = 0;
        for (int r = rows - 1; r >= 0; r--) {
            int j = 0;
            for (int c = cols - 1; c >= 0; c--) {
                if (j < matrix[i].length){
                    matrix180[r][c] = matrix[i][j];
                    j++;
                }else {
                    break;
                }
            }
            i++;
        }
        printMatrix (matrix180);
    }

    private static
    void matrix90 (int rows, int cols, char[][] matrix) {
        char[][] matrix90 = new char[rows][cols];
        int      i        = 0;
        for (int c = cols - 1; c >= 0; c--) {
            int j = 0;
            for (int r = 0; r < matrix[i].length; r++) {
                matrix90[r][c] = matrix[i][j];
                j++;
            }
            i++;
        }
        printMatrix (matrix90);

    }

    private static
    void matrix270 (int rows, int cols, char[][] matrix) {
        char[][] matrix270 = new char[rows][cols];
        int      i         = 0;
        for (int c = 0; c < cols; c++) {
            int j = 0;
            for (int r = rows - 1; r >= 0; r--) {
                if (j < matrix[i].length) {
                    matrix270[r][c] = matrix[i][j];
                    j++;
                } else {
                    break;
                }
            }
            i++;
        }

        printMatrix (matrix270);


    }

    private static
    void printMatrix (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print (matrix[i][j]);
                } else {
                    System.out.print (' ');
                }
            }
            System.out.println ();

        }
    }


}
