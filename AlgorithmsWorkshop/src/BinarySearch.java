import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public
class BinarySearch {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] array = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int key = Integer.parseInt (scanner.nextLine ());


        System.out.println (getIndex (array, key));
    }

    private static
    int getIndex (int[] array, int key) {
        int l = 0;
        int r = array.length - 1;

        while (l<=r){
            int mid = (r+l)/2;
            if (array[mid]>key){
                r = mid -1;
            }else if (array[mid]<key){
                r = mid + 1;
            }else return mid;


        }
        return -1;

    }
}
