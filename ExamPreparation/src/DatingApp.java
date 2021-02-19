import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public
class DatingApp {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int matches = 0;

        ArrayDeque<Integer> malesStack   = new ArrayDeque<> ();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<> ();

        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (malesStack::push);
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (femalesQueue::offer);


        while (!malesStack.isEmpty () && !femalesQueue.isEmpty ()) {
            int currantMale   = malesStack.peek ();
            int currantFemale = femalesQueue.peek ();
            if (currantFemale <= 0) {
                femalesQueue.poll ();
                continue;
            }

            if (currantMale <=0){
                malesStack.pop ();
                continue;
            }

            if (currantMale%25==0 && malesStack.size () > 1) {
                malesStack.pop ();
                malesStack.pop ();
                continue;
            }
            if (currantMale % 25 == 0) {
                malesStack.pop ();
                continue;
            }

            if (currantFemale%25==0 && femalesQueue.size () > 1) {
                femalesQueue.poll ();
                femalesQueue.poll ();
                continue;
            }
            if (currantFemale % 25 == 0) {
                femalesQueue.poll ();
                continue;
            }

            if (currantFemale == currantMale) {
                femalesQueue.poll ();
                malesStack.pop ();
                matches += 1;
            } else {
                femalesQueue.poll ();
                malesStack.push (malesStack.pop () - 2);
            }
        }

        System.out.println ("Matches: " + matches);
        System.out.print ("Males left: ");
        if (malesStack.isEmpty ()) {
            System.out.println ("none");
        } else {
            while (malesStack.size () > 1) {
                System.out.print (malesStack.pop () + ", ");
            }
            System.out.println (malesStack.pop ());
        }
        System.out.print ("Females left: ");
        if (femalesQueue.isEmpty ()){
            System.out.println ("none");
        }else {
            while (femalesQueue.size ()>1){
                System.out.print (femalesQueue.poll () + ", ");
            }
            System.out.println (femalesQueue.poll ());
        }
    }
}
