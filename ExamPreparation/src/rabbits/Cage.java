package rabbits;

import java.util.ArrayList;
import java.util.List;

public
class Cage {
    private String name;
   private int capacity;
   private List<Rabbit> data;

    public
    Cage (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<> ();
    }


    public
    String getName () {
        return this.name;
    }

    public
    int getCapacity () {
        return this.capacity;
    }

    public void add(Rabbit rabbit){
        if (this.capacity>this.data.size ()){
            this.data.add (rabbit);
        }
    }
    public boolean removeRabbit(String name){
        return data.removeIf (rabbit -> rabbit.getName ().equals (name));
    }
    public void removeSpecies(String species){
        data.removeIf (rabbit -> rabbit.getSpecies ().equals (species));
    }
    public Rabbit sellRabbit(String name){
        Rabbit rabbitToSell = null;
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName ().equals (name)){
                rabbit.setAvailable (false);
                rabbitToSell = rabbit;
            }
        }return rabbitToSell;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbitsToSell = new ArrayList<> ();
        this.data.forEach (rabbit -> {
            if (rabbit.getSpecies ().equals (species)) {
              rabbitsToSell.add (sellRabbit (rabbit.getName ()));
            }
        });
        return rabbitsToSell;
    }

    public int count(){
        return data.size ();
    }
    public String report(){
        StringBuilder sb = new StringBuilder ("Rabbits available at " + this.name);
       sb.append (":").append (System.lineSeparator ());
       this.data.stream ().filter (Rabbit::isAvailable).forEach (rabbit -> sb.append (rabbit).append (System.lineSeparator ()));
       return sb.toString ().trim ();
    }


}
