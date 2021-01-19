import java.util.Arrays;
import java.util.Scanner;

public
class ParkingSystem {
    public static
    void main (String[] args) {
        Scanner scanner    = new Scanner (System.in);
        int[]   dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int     rows       = dimensions[0];
        int     cols       = dimensions[1];

        boolean[][] isOccupied = new boolean[rows][cols];
        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }

        String command;

        while (!"stop".equals (command = scanner.nextLine ())) {
            int[] tokens    = Arrays.stream (command.split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
            int   entryRow  = tokens[0];
            int   targetRow = tokens[1];
            int   targetCol = tokens[2];

            boolean rowIsOccupied = true;

            for (int i = 0; i < isOccupied[targetRow].length; i++) {
                if (!isOccupied[targetRow][i]) {
                    rowIsOccupied = false;break;
                }
            }
            int moves = 1;
            if (rowIsOccupied) {
                System.out.printf ("Row %d full%n", targetRow);
            } else if (!isOccupied[targetRow][targetCol]) {
                parkTheCar (isOccupied, entryRow, targetRow, targetCol, moves);
            } else {

                for (int i = 1; i < isOccupied[targetRow].length; i++) {
                    if (targetCol - i > 0 && !isOccupied[targetRow][targetCol - i]) {
                        parkTheCar (isOccupied, entryRow, targetRow, targetCol - i, moves);break;
                    } else if (targetCol + i < isOccupied[targetRow].length && !isOccupied[targetRow][targetCol+i]){
                        parkTheCar (isOccupied,entryRow,targetRow,targetCol + i, moves);break;
                    }
                }
            }


        }


    }

    private static
    void parkTheCar (boolean[][] isOccupied, int entryRow, int targetRow, int targetCol, int moves) {
        moves = moves + Math.abs (targetRow - entryRow) + targetCol;
        System.out.println (moves);
        isOccupied[targetRow][targetCol] = true;
    }

}
