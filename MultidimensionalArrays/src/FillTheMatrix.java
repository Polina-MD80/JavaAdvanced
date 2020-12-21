import java.util.Scanner;

public
class FillTheMatrix {
    public static
    void main (String[] args) {
        Scanner  scanner = new Scanner (System.in);
        String[] command = scanner.nextLine ().split (", ");
        int      n       = Integer.parseInt (command[0]);
        String   type    = command[1];

        int[][] matrix = new int[n][n];

        switch (type) {
            case "A":
                typeA (matrix, n);
                break;
            case "B":
                typeB (matrix, n);
                break;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print (matrix[i][j]+" ");
            }
            System.out.println ();

        }

    }

    private static
    int[][] typeB (int[][] matrix, int n) {
        int number = 1;

        for (int col = 0; col < n; col++) {
            if (col%2==0){
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            }else for (int row = n-1; row >= 0 ; row--) {
                matrix[row][col] = number;
                number++;
            }
        }
        return matrix;
    }

    private static
    int[][] typeA (int[][] matrix, int n) {
        int number = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = number;
                number++;
            }

        }
        return matrix;
    }
}

