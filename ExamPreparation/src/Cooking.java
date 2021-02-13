import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Cooking {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int bread    = 0;//25
        int cake     = 0;//50
        int pastry   = 0; //75
        int fruitPie = 0; //100


        ArrayDeque<Integer> liquidDeque      = new ArrayDeque<> ();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<> ();
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (liquidDeque::offer);
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (ingredientsStack::push);

        while (!liquidDeque.isEmpty () && !ingredientsStack.isEmpty ()) {
            //remove only the liquid and increase the value of the ingredient by 3
            int liquid     = liquidDeque.poll ();
            int ingredient = ingredientsStack.pop ();

            int sum = liquid + ingredient;

            switch (sum) {
                case 25:
                    bread++;
                    break;
                case 50:
                    cake++;
                    break;
                case 75:
                    pastry++;
                    break;
                case 100:
                    fruitPie++;
                    break;
                default:
                    ingredientsStack.push (ingredient + 3);
                    break;

            }


        }

        if (bread>0&&cake>0&&pastry>0&&fruitPie>0){
            System.out.println ("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println ("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.print ("Liquids left: ");
        if (liquidDeque.isEmpty ()){
            System.out.println ("none");
        }else{
            printDeque (liquidDeque);
        }

        System.out.print ("Ingredients left: ");
        if (ingredientsStack.isEmpty ()){
            System.out.println ("none");
        }else {
            printStack(ingredientsStack);
        }
        System.out.println ("Bread: " + bread);
        System.out.println ("Cake: " + cake);
        System.out.println ("Fruit Pie: " + fruitPie);
        System.out.println ("Pastry: " + pastry);



    }
    private static
    void printDeque (ArrayDeque<Integer> deque) {
        while (deque.size () > 1){
            System.out.print (deque.poll () + ", ");
        }
        System.out.println(deque.poll ());
    }
    private static void printStack(ArrayDeque<Integer> stack){
        while (stack.size ()>1){
            System.out.print (stack.pop()+ ", ");
        }
        System.out.println (stack.pop ());
    }
}
