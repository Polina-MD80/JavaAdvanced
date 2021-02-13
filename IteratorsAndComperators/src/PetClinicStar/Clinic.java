package PetClinicStar;

import java.util.List;

public
class Clinic {
    private String name;
    private int size;
    public Room[] rooms;

    public
    Clinic (String name, int size) {
        this.name = name;
        this.size = size;
        this.rooms = new Room[size];
    }

    public
    String getName () {
        return name;
    }

    public
    Room[] getRooms () {
        return rooms;
    }
    public boolean hasEmptyRoom(){
        for (Room room : rooms) {
            if (room.getPetInTheRoom ().getName ().equals ("NoName")){
                return true;
            }
        }
        return false;
    }


}
