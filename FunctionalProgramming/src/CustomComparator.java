import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public
class CustomComparator {
    public static class ComparatorByNaturalOrder implements Comparator<Integer>{

        @Override
        public
        int compare (Integer o1, Integer o2) {
            return  Integer.compare (o1,o2);
        }
    }
    public static
    class ComparatorByEvenOdd implements Comparator<Integer>{

        @Override
        public
        int compare (Integer o1, Integer o2) {
            return Integer.compare (Math.abs (o1%2),Math.abs (o2%2));
        }
    }
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] numbers = Arrays.stream(scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray();
            Integer[] integers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integers[i] = numbers[i];
        }


       // Arrays.stream (numbers).boxed ().sorted (new ComparatorByEvenOdd()).forEach (e-> System.out.print (e + " "));
        Arrays.sort (integers,new ComparatorByNaturalOrder ());
        Arrays.sort (integers,new ComparatorByEvenOdd ());
        Arrays.stream (integers).forEach (e-> System.out.print (e + " "));
    }
}
