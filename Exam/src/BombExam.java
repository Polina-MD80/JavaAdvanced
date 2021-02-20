import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public
class BombExam {
    static char[][] matrix;
    static int[] player;
    static int nextStep[] ;
    static boolean endPosition = false;
    static int bombs;

    public static
    void main (String[] args) {
        Scanner  scanner = new Scanner (System.in);
        int      n       = Integer.parseInt (scanner.nextLine ());
        String[] input   = scanner.nextLine ().split (",");

        matrix = readMatrix (scanner, n);
        player = findThePlayer ();


        for (int i = 0; i < input.length; i++) {
            String command = input[i];
            moveThePlayer (command);
            if (bombs == 0){
                break;
            }
            if (endPosition){
                break;
            }
        }
        if (bombs ==0){
            System.out.println ("Congratulations! You found all bombs!");
        }else if (endPosition){
            System.out.printf ("END! %d bombs left on the field",bombs);
        }else {
            System.out.printf ("%d bombs left on the field. Sapper position: (%d,%d)",bombs,player[0],player[1]);
        }

    }

    private static
    int[] findThePlayer () {
        player = new int[2];
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 's') {
                    player[0] = i;
                    player[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return player;
    }

    private static
    void moveThePlayer (String command) {
        nextStep = new int[2];
        nextStep[0] = player[0];
        nextStep[1] = player[1];

        switch (command) {
            case "up":
                nextStep[0] -= 1;
                break;
            case "down":
                nextStep[0] += 1;
                break;
            case "left":
                nextStep[1] -= 1;
                break;
            case "right":
                nextStep[1] += 1;
                break;
        }

        if (isInBound(nextStep)){
            matrix[player[0]][player[1]] = '+';
            if (matrix[nextStep[0]][nextStep[1]] == 'B'){
                System.out.println ("You found a bomb!");
                bombs--;
            }else if (matrix[nextStep[0]][nextStep[1]] == 'e'){
                endPosition = true;
            }
            player[0] = nextStep[0];
            player[1] = nextStep[1];
        }
    }

    private static
    boolean isInBound (int[] nextStep) {
        return nextStep[0]>=0 && nextStep[0] < matrix.length && nextStep[1]>=0
               && nextStep[1] < matrix[nextStep[0]].length;
    }

    private static
    char[][] readMatrix (Scanner scanner, int n) {
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine ().replace (" ", "").toCharArray ();
            for (char c : matrix[i]) {
                if (c == 'B') {
                    bombs++;
                }
            }
        }
        return matrix;
    }
}
