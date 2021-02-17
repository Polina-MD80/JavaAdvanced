import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public
class PresentDelivery {

    static char[][] matrix;
    static int[] santa;
    static int presents;


    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        presents = Integer.parseInt (scanner.nextLine ());

        int dimensions = Integer.parseInt (scanner.nextLine ());

        matrix = readMatrix (dimensions, scanner);

        int goodKids = findGoodKids();

        int initialGoodKids = goodKids;

        santa = findCoordinates ('S');

        String command;

        while (!("Christmas morning").equals (command = scanner.nextLine ())) {
            moveSanta (command);
            givePresents ();
            if (presents<=0){
                break;
            }

        }
        goodKids = findGoodKids ();
        if (presents ==0){
            System.out.println ("Santa ran out of presents!");
        }
        printMatrix ();
        if (goodKids==0){
            System.out.printf ("Good job, Santa! %d happy nice kid/s.%n",initialGoodKids);
        }else {
            System.out.printf ("No presents for %d nice kid/s.%n", goodKids);
        }

    }

    private static
    int findGoodKids () {
        int goodKids = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'V'){
                    goodKids++;
                }
            }
        }
        return goodKids;
    }

    private static
    void givePresents () {
        if (matrix[santa[0]][santa[1]] == '-' || matrix[santa[0]][santa[1]] == 'X') {
            setNewSantaPosition ();
        } else if (matrix[santa[0]][santa[1]] == 'V') {
            presents--;
            setNewSantaPosition ();
        } else if (matrix[santa[0]][santa[1]] == 'C') {
            spreadPresentsHappySanta ();
            setNewSantaPosition ();
        }
    }

    private static
    void spreadPresentsHappySanta () {
        List<int[]> listOfCoordinates = List.of (new int[]{santa[0] - 1, santa[1]},
                new int[]{santa[0] + 1, santa[1]}, new int[]{santa[0], santa[1] - 1}, new int[]{santa[0], santa[1] + 1});
        for (int[] coordinate : listOfCoordinates) {
            if (matrix[coordinate[0]][coordinate[1]] == 'V' || matrix[coordinate[0]][coordinate[1]] == 'X') {
                leaveTheDash (coordinate);
                presents--;
            }
        }
    }

    private static
    void setNewSantaPosition () {
        matrix[santa[0]][santa[1]] = 'S';
    }

    private static
    void moveSanta (String command) {
        leaveTheDash (santa);
        switch (command) {
            case "up":
                santa[0] -= 1;
                break;
            case "down":
                santa[0] += 1;
                break;
            case "left":
                santa[1] -= 1;
                break;
            case "right":
                santa[1] += 1;
                break;
        }
    }

    private static
    void leaveTheDash (int[] coordinates) {
        matrix[coordinates[0]][coordinates[1]] = '-';
    }

    private static
    int[] findCoordinates (char symbol) {
        int[]   coordinates = new int[2];
        boolean isFound     = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == symbol) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return coordinates;
    }

    private static
    void printMatrix () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j] + " ");
            }
            System.out.println ();
        }
    }

    private static
    char[][] readMatrix (int dimensions, Scanner scanner) {
        char[][] matrix = new char[dimensions][];
        for (int i = 0; i < dimensions; i++) {
            matrix[i] = scanner.nextLine ().replace (" ", "").toCharArray ();
        }
        return matrix;
    }
}
