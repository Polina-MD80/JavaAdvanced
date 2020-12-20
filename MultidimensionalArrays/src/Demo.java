public
class Demo {
    public static
    void main (String[] args) {
        int [][] matrix = new int[10][10];
        System.out.println (matrix[0][0]);//0

        int[][] matrix1 = {
                {1,3},
                {2,5,6},
        };
        int [] innerArray = matrix1[0];
        System.out.println (innerArray[0]);//1
        System.out.println (matrix1[1][2]);//6
    }
}
