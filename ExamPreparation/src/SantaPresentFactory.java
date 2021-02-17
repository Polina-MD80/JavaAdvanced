import java.util.*;

public
class SantaPresentFactory {
    public static
    void main (String[] args) {
        Scanner scanner     = new Scanner (System.in);
        int     doll        = 0; //150
        int     woodenTrain = 0; //250
        int     teddyBear   = 0; //300
        int     bicycle     = 0; //400

        ArrayDeque<Integer> materialStack = new ArrayDeque<> ();
        ArrayDeque<Integer> magicQueue    = new ArrayDeque<> ();

        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (materialStack::push);
        Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).forEach (magicQueue::offer);

        while (!materialStack.isEmpty () && !magicQueue.isEmpty ()) {
            int currantMaterial = materialStack.peek ();
            int currantMagic    = magicQueue.peek ();
            int product         = currantMagic * currantMaterial;
            if (product < 0) {
                int newMaterial = currantMaterial + currantMagic;
                materialStack.pop ();
                materialStack.push (newMaterial);
                magicQueue.poll ();
            } else if (product > 0) {
                magicQueue.poll ();
                materialStack.pop ();
                switch (product) {
                    case 150:
                        doll++;
                        break;
                    case 250:
                        woodenTrain++;
                        break;
                    case 300:
                        teddyBear++;
                        break;
                    case 400:
                        bicycle++;
                        break;
                    default:
                        materialStack.push (currantMaterial + 15);break;
                }
            }else {
                if (currantMagic==0){
                    magicQueue.poll ();
                }else {
                    materialStack.pop ();
                }
            }
        }//a doll and a train
        //teddy bear and a bicycle.
        if ((doll > 0 && woodenTrain > 0) || (teddyBear > 0 && bicycle > 0)) {
            System.out.println ("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println ("No presents this Christmas!");
        }
        if (!materialStack.isEmpty ()) {
            StringBuilder sb = new StringBuilder ("Materials left: ");
            while (materialStack.size () > 1) {
                sb.append (materialStack.pop ()).append (", ");
            }sb.append (materialStack.pop ());
            System.out.println (sb);
        }
        if (!magicQueue.isEmpty ()){
            StringBuilder sb = new StringBuilder ("Magic left: ");
            while (magicQueue.size ()>1){
                sb.append (magicQueue.poll()).append (", ");
            }sb.append (magicQueue.poll ());
            System.out.println (sb);
        }
        if (bicycle>0){
            System.out.printf ("Bicycle: %d%n",bicycle);
        }
        if (doll>0){
            System.out.printf ("Doll: %d%n",doll);
        }if (teddyBear>0){
            System.out.printf ("Teddy bear: %d%n",teddyBear);
        }if (woodenTrain>0){
            System.out.printf ("Wooden train: %d%n",woodenTrain);
        }
    }
}
