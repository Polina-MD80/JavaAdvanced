import java.util.Scanner;

public
class SnakeBetterSolution {
    static char[][] matrix;
    static int food = 0;
    static int[] snake;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }

        snake = findTheChar ('S');

        boolean isDead = false;

        while (food < 10 && !isDead) {
            String command = scanner.nextLine ();
            matrix[snake[0]][snake[1]] = '.';
            switch (command) {

                case "up":
                    snake[0] -= 1;
                    isDead = moveTheSnake ();
                    break;
                case "down":
                    snake[0] += 1;
                    isDead = moveTheSnake ();
                    break;
                case "left":
                    snake[1] -= 1;
                    isDead = moveTheSnake ();
                    break;
                case "right":
                    snake[1] += 1;
                    isDead = moveTheSnake ();
                    break;
            }
        }

        if (isDead) {
            System.out.println ("Game over!");
        } else {
            System.out.println ("You won! You fed the snake.");
        }
        System.out.printf ("Food eaten: %d%n", food);
        printTheMatrix();


    }

    private static
    void printTheMatrix () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
    }

    private static
    boolean moveTheSnake () {
        if (isOutOfMatrix ()) {
            return true;
        } else {
            if (matrix[snake[0]][snake[1]] == '*') {
                food++;
            } else if (matrix[snake[0]][snake[1]] == 'B') {
                matrix[snake[0]][snake[1]] = '.';
                snake = findTheChar ('B');
            }
            matrix[snake[0]][snake[1]] = 'S';
        }
        return false;
    }

    private static
    boolean isOutOfMatrix () {
        return snake[0] < 0 || snake[0] >= matrix.length
               || snake[1] < 0 || snake[1] >= matrix[snake[0]].length;
    }

    private static
    int[] findTheChar (char character) {
        int[]   arr     = new int[2];
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == character) {
                    arr[0] = i;
                    arr[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return arr;
    }
}
