import java.util.Arrays;
import java.util.Scanner;

public
class RadioactiveMutantVampireBunnies {
    public static
    void main (String[] args) {
        Scanner scanner    = new Scanner (System.in);
        int[]   dimensions = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }
        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        char[] command = scanner.nextLine ().toCharArray ();

        boolean won  = false;
        boolean dead = false;

        for (int i = 0; i < command.length; i++) {
            switch (command[i]) {
                case 'U':
                    if (inMatrix (playerRow - 1, playerCol, matrix)) {
                        matrix[playerRow][playerCol] = '.';
                        playerRow -= 1;
                        if (jumpOnBunnie (playerRow, playerCol, matrix)) {
                            dead = isDead (matrix);
                        } else {
                            matrix[playerRow][playerCol] = 'P';
                            spreadBunnies (matrix);

                            if (!foundPlayer (matrix)) {
                                dead = true;
                            }
                        }
                    } else {
                        won = true;
                    }
                    break;
                case 'D':
                    // playerRow += 1;
                    if (inMatrix (playerRow  +1, playerCol, matrix)) {
                        matrix[playerRow][playerCol] = '.';
                        playerRow += 1;
                        if (jumpOnBunnie (playerRow, playerCol, matrix)) {
                            dead = isDead (matrix);
                        } else {
                            matrix[playerRow][playerCol] = 'P';
                            spreadBunnies (matrix);
                            if (!foundPlayer (matrix)) {
                                dead = true;
                            }

                        }
                    } else {
                        won = true;
                    }
                    break;
                case 'L':
                    if (inMatrix (playerRow, playerCol - 1, matrix)) {
                        matrix[playerRow][playerCol] = '.';
                        playerCol -= 1;
                        if (jumpOnBunnie (playerRow, playerCol, matrix)) {
                            dead = isDead (matrix);
                        } else {
                            matrix[playerRow][playerCol] = 'P';
                            spreadBunnies (matrix);
                            if (!foundPlayer (matrix)) {
                                dead = true;
                            }

                        }
                    } else {
                        won = true;
                    }
                    break;
                case 'R':
                    if (inMatrix (playerRow, playerCol + 1, matrix)) {
                        matrix[playerRow][playerCol] = '.';
                        playerCol += 1;
                        if (jumpOnBunnie (playerRow, playerCol, matrix)) {
                           dead = isDead (matrix);
                        } else {
                            matrix[playerRow][playerCol] = 'P';
                            spreadBunnies (matrix);
                            if (!foundPlayer (matrix)) {
                                dead = true;
                            }
                        }
                    } else {
                        won = true;

                    }
                    break;
            }
            if (won) {
                matrix[playerRow][playerCol] = '.';
                spreadBunnies (matrix);
                break;
            }
            if (dead) {
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
        if (won) {
            System.out.println ("won: " + playerRow +" " + playerCol);
        }
        if (dead) {
            System.out.println ("dead: " + playerRow +" " + playerCol);
        }
    }

    private static
    boolean isDead (char[][] matrix) {
        boolean dead;
        dead = true;
        spreadBunnies (matrix);
        return dead;
    }

    private static
    boolean foundPlayer (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    return true;
                }
            }
        }
        return false;
    }

    private static
    boolean jumpOnBunnie (int playerRow, int playerCol, char[][] matrix) {
        if (matrix[playerRow][playerCol] == 'B') {
            return true;
        }
        return false;
    }

    private static
    void spreadBunnies (char[][] matrix) {
        int      m         = matrix[0].length;
        char[][] newMatrix = new char[matrix.length][m];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (newMatrix[i][j] == 'B') {
                    if (inMatrix (i - 1, j, matrix)) {
                        matrix[i - 1][j] = 'B';
                    }
                    if (inMatrix (i + 1, j, matrix)) {
                        matrix[i + 1][j] = 'B';
                    }
                    if (inMatrix (i, j - 1, matrix)) {
                        matrix[i][j - 1] = 'B';
                    }
                    if (inMatrix (i, j + 1, matrix)) {
                        matrix[i][j + 1] = 'B';
                    }
                }
            }
        }

    }

    private static
    boolean inMatrix (int i, int j, char[][] matrix) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length;
    }
}
