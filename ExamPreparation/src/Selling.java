import java.util.Scanner;

public
class Selling {
    static int dollars = 0;
    static int[] seller = new int[2];
    static char[][] matrix;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());

       matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    seller[0] = i;
                    seller[1] = j;
                    break;
                }
            }
        }
        boolean outOfBakery = false;

        while (!outOfBakery && dollars < 50) {
            String command = scanner.nextLine ();

            matrix[seller[0]][seller[1]] = '-';

            switch (command) {
                case "up":
                    seller[0] -= 1;
                    outOfBakery = moveTheSeller ();
                    break;
                case "down":
                    seller[0] += 1;
                    outOfBakery = moveTheSeller ();
                    break;
                case "left":
                    seller[1] -= 1;
                    outOfBakery = moveTheSeller ();
                    break;
                case "right":
                    seller[1] += 1;
                    outOfBakery = moveTheSeller ();
                    break;
            }

        }
       if (outOfBakery){
           System.out.println ("Bad news, you are out of the bakery.");
       }else {
           System.out.println ("Good news! You succeeded in collecting enough money!");
       }
        System.out.println ("Money: " + dollars);
       printMatrix(matrix);


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

    public static
    boolean moveTheSeller () {
        if (outOfMatrix (seller, matrix)) {
            return true;
        } else {
            if (Character.isDigit (matrix[seller[0]][seller[1]])) {
                dollars += matrix[seller[0]][seller[1]] - '0';
            } else if (matrix[seller[0]][seller[1]] == 'O') {
                matrix[seller[0]][seller[1]] = '-';
                seller = findPillar(matrix);
            }
            matrix[seller[0]][seller[1]] = 'S';
            return false;
        }
    }

    private static
    int[] findPillar (char[][] matrix) {
        int[] pillar = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'O'){
                   pillar[0] = i;
                   pillar[1] = j;break;
                }
            }
        }
        return pillar;
    }

    private static
    boolean outOfMatrix (int[] seller, char[][] matrix) {
        return seller[0] < 0 || seller[0] >= matrix.length
               || seller[1] < 0 || seller[1] >= matrix[seller[0]].length;
    }
}
