import java.util.Scanner;

public
class ReVolt {
    static char[][] matrix;
    static int[] player;
    static int[] previous;
    static boolean finished = false;

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int N = Integer.parseInt (scanner.nextLine ());
        int n = Integer.parseInt (scanner.nextLine ());
        matrix = new char[N][N];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }
        player = findCharacter ('f');


        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine ();
            previous = new int[]{player[0],player[1]};
            leaveTheDash ();
            moveToDirection (command);
            checkTheNewPositionChar(command);
            if (finished){
                break;
            }
        }
        if (finished){
            System.out.println ("Player won!");
        }else System.out.println ("Player lost!");

        printMatrix ();
    }

    private static
    void checkTheNewPositionChar (String command) {
        if (matrix[player[0]][player[1]]=='-'){
            setThePlayer ();
        }else if (matrix[player[0]][player[1]]=='B'){
            moveToDirection (command);
            if (matrix[player[0]][player[1]]=='F'){
                finished = true;
            }
            setThePlayer ();
        }else if(matrix[player[0]][player[1]]=='T'){
           player[0] = previous[0];
           player[1] = previous[1];
           setThePlayer ();
        }else {
            setThePlayer ();
            finished = true;
        }
    }

    private static
    void setThePlayer () {
        matrix[player[0]][player[1]] = 'f';
    }

    private static
    void moveToDirection (String command) {
        int row = player[0];
        int col = player[1];
        switch (command) {
            case "up":
                if (row - 1 < 0) {
                    row = matrix.length - 1;
                } else row -= 1;
                break;
            case "down":
                if (row + 1 >= matrix.length) {
                    row = 0;
                } else {
                    row += 1;
                }
                break;
            case "left":
                if (col-1<0){
                    col = matrix[row].length-1;
                }else {
                    col-=1;
                }
                break;
            case "right":
                if (col+1>= matrix[row].length){
                    col = 0;
                }else {
                    col += 1;
                }
                break;
        }
        player[0] = row;
        player[1]= col;
    }

    private static
    void leaveTheDash () {
        matrix[player[0]][player[1]] = '-';
    }

    private static
    int[] findCharacter (char character) {
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

    private static
    void printMatrix () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j]);
            }
            System.out.println ();
        }
    }
}
