import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ParkingSystem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(scanner.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        boolean[][] parkingLot = new boolean[dimensions[0]][dimensions[1]];
        String input = "";
        int currentPosCol = 0;

        while (!"stop".equals(input = scanner.readLine())) {

            String[] commands = input.split("\\s+");
            int startingRow = Integer.parseInt(commands[0]);
            int desiredRow = Integer.parseInt(commands[1]);
            int desiredCol = Integer.parseInt(commands[2]);
            boolean isFree = !parkingLot[desiredRow][desiredCol];

            if (isFree) {
                parkTheCaR(parkingLot, currentPosCol, startingRow, desiredRow, desiredCol);
            } else {
                boolean[] row = parkingLot[desiredRow];
                int newSpot = checkForSpot(desiredCol, row);
                if (newSpot == 0) {
                    System.out.printf("Row %d full%n", desiredRow);
                } else {
                    desiredCol = newSpot;
                    parkTheCaR(parkingLot, currentPosCol, startingRow, desiredRow, desiredCol);
                }
            }
        }
    }

    private static void parkTheCaR(boolean[][] parkingLot, int currentPosCol, int startingRow, int desiredRow, int desiredCol) {
        int moves = 1;
        moves += Math.abs(desiredRow - startingRow);
        for (int col = 1; col <= desiredCol; col++) {
            moves++;
            currentPosCol = col;
        }
        parkingLot[desiredRow][currentPosCol] = true;
        System.out.println(moves);

    }

    private static int checkForSpot(int desiredCol, boolean[] row) {
        for (int i = 1; i < row.length; i++) {
            if (desiredCol - i > 0 && !row[desiredCol - i]) {
               return desiredCol - i;
            } else if (desiredCol + i < row.length && !row[desiredCol+i]){
               return  desiredCol + i;
            }
        }
        return 0;
    }
}
 