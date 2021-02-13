import java.util.Arrays;
import java.util.Scanner;

public
class Garden {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        String command;

        while (!"Bloom Bloom Plow".equals (command = scanner.nextLine ())){
            int[] coordinates = Arrays.stream (command.split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

            if (inboundMatrix(coordinates,matrix)){
                int row = coordinates[0];
                int col = coordinates[1];
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][col] += 1;
                }
                for (int j = 0; j < matrix[row].length; j++) {
                    matrix[row][j] +=1;
                }
                matrix[row][col] -= 1;
            }
        }

        printMatrix(matrix);
    }

    private static
    boolean inboundMatrix (int[] coordinates, int[][] matrix) {
        return coordinates[0] >=0 && coordinates[0] < matrix.length
               && coordinates[1] >= 0 && coordinates[1]<matrix[coordinates[0]].length;
    }

    private static
    void printMatrix (int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder ();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append (matrix[i][j]).append (" ");
            }
            System.out.println (sb.toString ().trim ());
        }
    }
}
