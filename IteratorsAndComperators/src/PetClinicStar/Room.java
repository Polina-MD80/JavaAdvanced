package PetClinicStar;

public
class Room {
    private Pet petInTheRoom;

    public
    Room () {
        this.petInTheRoom = new Pet ("NoName",-1, "NoKind");
    }

    public
    void setPetInTheRoom (Pet petInTheRoom) {
        this.petInTheRoom = petInTheRoom;
    }

    public
    Pet getPetInTheRoom () {
        return petInTheRoom;
    }

    public void releasePet(){
        this.petInTheRoom = null;
    }
}
