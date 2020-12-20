import java.util.Arrays;
import java.util.Scanner;

public
class CompareMatrices {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);


        int[][] firstMatrix = readMatrix (scanner);
        int[][] secondMatrix = readMatrix (scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);
        /*if (areEqual){
            System.out.println ("equal");
        }else System.out.println ("not equal");*/
        System.out.println (areEqual ? "equal" : "not equal");

    }

    private static
    boolean compareMatrices (int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if(secondArr.length != firstArr.length){
                return false;
            }
            for (int coll = 0; coll < firstArr.length; coll++) {
                if (firstArr[coll] != secondArr[coll]){
                    return false;
                }
            }
        }
        return true;
    }

    private static
    int[][] readMatrix (Scanner scanner) {
        int rows = scanner.nextInt ();
        int cols = scanner.nextInt ();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt ();
            }
        }
        return matrix;
    }
}
