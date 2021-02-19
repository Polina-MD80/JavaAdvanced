import java.util.Scanner;

public
class BookWorm {
    static int[] warm;
    static StringBuilder word;
    static char[][] matrix;

    static int[] lastPosition = new int[2];

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        word = new StringBuilder (scanner.nextLine ().trim ());
        int n = Integer.parseInt (scanner.nextLine ().trim ());
        readMatrix (n, scanner);
        findTheWarm ();
        String command;
        while (!"end".equals (command = scanner.nextLine ().trim ())) {
            moveTheWarm(command);

        }

        System.out.println (word);


        printMatrix ();
    }

    private static
    void moveTheWarm (String command) {
        lastPosition[0]=warm[0];
        lastPosition[1]= warm[1];
        switch (command){
            case "up":
                warm[0] -= 1;
                break;
            case "down":
                warm[0] += 1;
                break;
            case "left":
                warm[1] -=1;
                break;
            case "right":
                warm[1] +=1;
                break;
        }
        boolean outBound = checkOutBound();
        if (outBound){
            word = word.deleteCharAt (word.length ()-1);
            warm[0] = lastPosition[0];
            warm[1] = lastPosition[1];
        }if (!outBound){
            matrix[lastPosition[0]][lastPosition[1]]= '-';
            if (matrix[warm[0]][warm[1]]!='-'){
                word.append (matrix[warm[0]][warm[1]]);
                matrix[warm[0]][warm[1]] = 'P';
            }
        }
    }

    private static
    boolean checkOutBound () {
        return warm[0]>=matrix.length || warm[0]<0 || warm[1]<0 || warm[1]>= matrix[warm[0]].length;
    }

    private static
    void findTheWarm () {
        warm = new int[2];
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    warm[0] = i;
                    warm[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
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
    void readMatrix (int n, Scanner scanner) {
        matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine ().toCharArray ();
        }
    }

}
