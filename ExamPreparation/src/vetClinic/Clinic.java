package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public
class Clinic  {
    private int capacity;
    private List<Pet> data;

    public
    Clinic (int capacity) {
        this.capacity = capacity;
        data = new ArrayList<> ();
    }

    public
    void add (Pet pet) {
        if (!this.data.contains (pet)) {
            if (capacity > this.data.size ()) {
                this.data.add (pet);
            }
        }
    }

    public
    boolean remove (String name) {
        for (Pet pet : this.data) {
            if (pet.getName ().equals (name)){
                this.data.remove (pet);
                return true;
            }
        }
        return false;
    }

    public
    Pet getPet (String name, String owner) {
        Pet searchPet = null;
        for (Pet pet : this.data) {
            if (pet.getName ().equals (name) && pet.getOwner ().equals (owner)) {
                searchPet = pet;
            }
        }
        return searchPet;
    }
    public Pet getOldestPet(){
       return this.data.stream().max (Comparator.comparing (Pet::getAge)).orElseThrow ();
    }
    public int getCount(){
        return this.data.size ();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder ("The clinic has the following patients:" + System.lineSeparator ());
        for (Pet pet : this.data) {
            sb.append (String.format ("%s %s%n", pet.getName (),pet.getOwner ()));
        }
        return sb.toString ().trim ();
    }
}
