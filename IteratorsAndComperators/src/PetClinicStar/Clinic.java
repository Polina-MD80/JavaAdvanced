package PetClinicStar;

import java.util.Iterator;
import java.util.List;

public
class Clinic implements Iterable<Pet>{
    private String name;
    private int capacity;
    public Pet[] rooms;

    public
    Clinic (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.rooms = new Pet[capacity];
    }

    public
    Pet[] getRooms () {
        return rooms;
    }

    //Add {pet's name} {clinic's name}
    public boolean addPet(Pet pet){
        int startRoom = this.rooms.length/2;
        for (int i =0; i <= this.rooms.length/2; i++) {
           if (this.rooms[startRoom-i] == null){
               this.rooms[startRoom-i] = pet;
               return true;
           }else if (this.rooms[startRoom+i]==null){
               this.rooms[startRoom+i] = pet;
               return true;
           }
        }
        return false;
    }
    public boolean releasePet(){
        int startRoom = this.rooms.length/2;
        for (int i = startRoom; i < this.rooms.length; i++) {
            if (this.rooms[i]!=null){
                this.rooms[i]=null;
                return true;
            }
        }
        for (int i = 0; i < this.rooms.length/2 - 1; i++) {
            if (this.rooms[i]!=null){
                this.rooms[i] = null;
                return true;
            }
        }
        return false;

    }
    public boolean hasEmptyRooms(){
        for (Pet room : this.rooms) {
            if (room == null){
                return true;
            }
        }
        return false;
    }

    public
    String getName () {
        return name;
    }



    @Override
    public
    Iterator<Pet> iterator () {
      return new Iterator<Pet> () {
         private int index = 0;
          @Override
          public
          boolean hasNext () {
              return index < rooms.length -1;
          }

          @Override
          public
          Pet next () {
              return rooms[index++];
          }

      };
    }
}
