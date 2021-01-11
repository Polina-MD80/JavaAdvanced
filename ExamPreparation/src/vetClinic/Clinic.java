package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public
class Clinic  {
    private int capacity;
    private List<Pet> pets;

    public
    Clinic (int capacity) {
        this.capacity = capacity;
        pets = new ArrayList<> ();
    }

    public
    void add (Pet pet) {
        if (!this.pets.contains (pet)) {
            if (capacity > this.pets.size ()) {
                this.pets.add (pet);
            }
        }
    }

    public
    boolean remove (String name) {
        for (Pet pet : this.pets) {
            if (pet.getName ().equals (name)){
                this.pets.remove (pet);
                return true;
            }
        }
        return false;
    }

    public
    Pet getPet (String name, String owner) {
        Pet searchPet = null;
        for (Pet pet : this.pets) {
            if (pet.getName ().equals (name) && pet.getOwner ().equals (owner)) {
                searchPet = pet;
            }
        }
        return searchPet;
    }
    public Pet getOldestPet(){
       return this.pets.stream().max (Comparator.comparing (Pet::getAge)).orElseThrow ();
    }
    public int getCount(){
        return this.pets.size ();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder ("The clinic has the following patients:" + System.lineSeparator ());
        for (Pet pet : this.pets) {
            sb.append (String.format ("%s %s%n", pet.getName (),pet.getOwner ()));
        }
        return sb.toString ();
    }
}
