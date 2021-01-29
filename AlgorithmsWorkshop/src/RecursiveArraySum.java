import java.util.Arrays;
import java.util.Scanner;

public
class RecursiveArraySum {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] arr = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int index = arr.length-1;
        System.out.println (arrSum (arr, index));
    }

    private static
    int arrSum (int[] arr, int index) {
        if (index==0){
            return arr[0];
        }
        return arrSum (arr, index-1) + arr[index];

    }
}
