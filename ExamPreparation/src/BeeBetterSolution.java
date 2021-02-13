import java.util.Scanner;

public
class BeeBetterSolution {
    static int[] bee = new int[2];
    static char[][] matrix;
    static int flowers = 0;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }

        bee = findTheElement (matrix, 'B');
        int[] bonus = findTheElement (matrix, 'O');

        boolean isLost = false;

        String command;

        while (!isLost && !"End".equals (command = scanner.nextLine ())) {
            leaveTheDot ();
            switch (command) {
                case "up":
                    bee[0] -= 1;
                    if (checkForBonus (bonus)) {
                        bee[0] -= 1;
                    }
                    isLost = moveTheBee ();
                    break;
                case "down":
                    bee[0] += 1;
                    if (checkForBonus (bonus)) {
                        bee[0] += 1;
                    }
                    isLost = moveTheBee ();
                    break;
                case "left":
                    bee[1] -= 1;
                    if (checkForBonus (bonus)) {
                        bee[1] -= 1;
                    }
                    isLost = moveTheBee ();
                    break;
                case "right":
                    bee[1] += 1;
                    if (checkForBonus (bonus)) {
                        bee[1] += 1;
                    }
                    isLost = moveTheBee ();
                    break;
            }
        }
        if (isLost) {
            System.out.println ("The bee got lost!");
        }
        if (flowers >= 5) {
            System.out.printf ("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf ("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }
        printMatrix ();

    }

    private static
    void printMatrix () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
    }


    private static
    boolean checkForBonus (int[] bonus) {
        if (bonus[0] == bee[0] && bonus[1] == bee[1]) {
            leaveTheDot ();
            return true;
        }
        return false;
    }

    private static
    void leaveTheDot () {
        matrix[bee[0]][bee[1]] = '.';
    }

    private static
    boolean moveTheBee () {
        if (beeIsOutOfField (matrix, bee)) {
            return true;
        } else {
            if (matrix[bee[0]][bee[1]] == 'f') {
                flowers++;
            }
            matrix[bee[0]][bee[1]] = 'B';
        }
        return false;
    }

    private static
    boolean beeIsOutOfField (char[][] matrix, int[] bee) {
        return bee[0] < 0 || bee[0] >= matrix.length || bee[1] < 0 || bee[1] >= matrix[bee[0]].length;
    }

    private static
    int[] findTheElement (char[][] matrix, char character) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == character) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}
