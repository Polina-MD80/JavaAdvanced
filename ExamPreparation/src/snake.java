import java.util.Scanner;

public
class snake {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        char[][] matrix = new char[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }
        int[] snake = new int[2];

        boolean snakeIsFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    snake[0] = i;
                    snake[1] = j;
                    snakeIsFound = true;
                    break;
                }
                if (snakeIsFound) {
                    break;
                }
            }
        }
        int food = 0;

        while (food < 10) {
            String command = scanner.nextLine ();
            matrix[snake[0]][snake[1]] = '.';
            switch (command) {
                case "up":
                    if (indexesAreInTheField (snake[0] - 1, snake[1], matrix)) {
                        snake[0] = snake[0] - 1;

                        if (matrix[snake[0]][snake[1]] == '*') {
                            food++;
                            matrix[snake[0]][snake[1]] = 'S';
                        } else if (matrix[snake[0]][snake[1]] == 'B') {
                            matrix[snake[0]][snake[1]] = '.';

                            snake = moveSnake (matrix, snake);
                        }
                    } else {
                        gameOver (matrix, food);
                        return;
                    }

                    break;
                case "down":
                    if (indexesAreInTheField (snake[0] + 1, snake[1], matrix)) {
                        snake[0] = snake[0] + 1;
                        if (matrix[snake[0]][snake[1]] == '*') {
                            food++;
                            matrix[snake[0]][snake[1]] = 'S';
                        } else if (matrix[snake[0]][snake[1]] == 'B') {
                            matrix[snake[0]][snake[1]] = '.';
                            snake = moveSnake (matrix, snake);
                        }


                    } else {
                        gameOver (matrix, food);
                        return;
                    }

                    break;
                case "left":
                    if (indexesAreInTheField (snake[0], snake[1] - 1, matrix)) {
                        snake[1] = snake[1] - 1;
                        if (matrix[snake[0]][snake[1]] == '*') {
                            food++;
                            matrix[snake[0]][snake[1]] = 'S';
                        } else if (matrix[snake[0]][snake[1]] == 'B') {
                            matrix[snake[0]][snake[1]] = '.';

                            snake = moveSnake (matrix, snake);
                        }


                    } else {
                        gameOver (matrix, food);
                        return;

                    }

                    break;
                case "right":
                    if (indexesAreInTheField (snake[0], snake[1] + 1, matrix)) {
                        snake[1] = snake[1] + 1;
                        if (matrix[snake[0]][snake[1]] == '*') {
                            food++;
                            matrix[snake[0]][snake[1]] = 'S';
                        } else if (matrix[snake[0]][snake[1]] == 'B') {
                            matrix[snake[0]][snake[1]] = '.';

                            snake = moveSnake (matrix, snake);
                        }


                    } else {
                        gameOver (matrix, food);
                        return;


                    }

                    break;
            }


        }

        System.out.println ("You won! You fed the snake.");
        System.out.println ("Food eaten: 10");
        printMatrix (matrix);
    }

    private static
    int[] moveSnake (char[][] matrix, int[] snake) {
        boolean bIsFound = false;
        snake = moveToTheOtherB (matrix, snake, bIsFound);
        matrix[snake[0]][snake[1]] = 'S';
        return snake;
    }

    private static
    void gameOver (char[][] matrix, int food) {
        System.out.println ("Game over!");
        System.out.println ("Food eaten: " + food);
        printMatrix (matrix);
    }

    private static
    int[] moveToTheOtherB (char[][] matrix, int[] snake, boolean bIsFound) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    snake = new int[]{i, j};
                    bIsFound = true;
                    break;
                }
                if (bIsFound) {
                    break;
                }
            }

        }
        return snake;
    }

    private static
    void printMatrix (char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
    }


    private static
    boolean indexesAreInTheField (int i, int j, char[][] matrix) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length;
    }
}
