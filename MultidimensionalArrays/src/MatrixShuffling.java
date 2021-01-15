import java.util.Arrays;
import java.util.Scanner;

public
class MatrixShuffling {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+"))
              .mapToInt (Integer::parseInt).toArray ();
        int rows = dimensions[0];
        int cols = dimensions[1];
        if (rows==0||cols==0){
            System.out.println ("Invalid input!");
        }


        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine ().split ("\\s+");
        }

        String command;

        while (!"END".equals (command=scanner.nextLine ())){

            String[] tokens = command.split ("\\s+");
            if (!tokens[0].equals ("swap")){
                System.out.println ("Invalid input!");
                //command = scanner.nextLine ();
                continue;
            }if (tokens.length!=5){
                System.out.println ("Invalid input!");
                //command = scanner.nextLine ();
                continue;
            }
            int row1 = Integer.parseInt (tokens[1]);
            int col1 = Integer.parseInt (tokens[2]);
            int row2 = Integer.parseInt (tokens[3]);
            int col2 = Integer.parseInt (tokens[4]);
            if (IsValid(row1,col1,matrix)&&IsValid (row2,col2,matrix)){
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                for (String[] strings : matrix) {
                    for (String string : strings) {
                        System.out.print (string + " ");
                    }
                    System.out.println ();
                }
            }else {
                System.out.println ("Invalid input!");
            }

            //command = scanner.nextLine ();
        }
    }

    private static
    boolean IsValid (int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    }


