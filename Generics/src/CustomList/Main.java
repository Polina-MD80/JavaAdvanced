package CustomList;

import java.util.Iterator;
import java.util.Scanner;

public
class Main {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        //•	Add <element> - Adds the given element to the end of the list
        //•	Remove <index> - Removes the element at the given index
        //•	Contains <element> - Prints if the list contains the given element (true or false)
        //•	Swap <index> <index> - Swaps the elements at the given indexes
        //•	Greater <element> - Counts the elements that are greater than the given element and prints their count
        //•	Max - Prints the maximum element in the list
        //•	Min - Prints the minimum element in the list
        //•	Print - Prints all elements in the list, each on a separate line
        //•	END - stops the reading of commands
        String input = scanner.nextLine ();

        CustomList<String> customList = new CustomList<String> ();
        while (!input.equals ("END")) {
            String[] tokens = input.split ("\\s+");
            switch (tokens[0]) {
                case "Add":
                    customList.add (tokens[1]);
                    break;
                case "Remove":
                    customList.remove (Integer.parseInt (tokens[1]));
                    break;
                case "Contains":
                    System.out.println (customList.contains (tokens[1]));
                    break;
                case "Swap":
                    customList.swap (Integer.parseInt (tokens[1]), Integer.parseInt (tokens[2]));
                    break;
                case "Greater":
                    System.out.println (customList.countGreaterThan (tokens[1]));
                    break;
                case "Max":
                    System.out.println (customList.getMax ());
                    break;
                case "Min":
                    System.out.println (customList.getMin ());
                    break;
                case "Print":
                   //System.out.println (customList);

                    customList.iterator ().forEachRemaining (System.out::println);

                    break;
                case "Sort":
                   Sorter.sort (customList);break;

                default: {
                    System.out.println ("Invalid command");
                    break;
                }
            }

            input = scanner.nextLine ();
        }
    }
}
