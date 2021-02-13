package PetClinicStar;

import Book.Book;

import java.util.Iterator;

public
class AddIterator implements Iterator<Room> {
    private Room[] rooms;
    private int index;

    public
    AddIterator () {
        this.index = rooms.length / 2;
    }

    int lastIndex = rooms.length - 1;

    @Override
    public
    boolean hasNext () {

        if (index >= rooms.length / 2) {
            return index <= lastIndex;
        } else {
            return index >= 0 && index < rooms.length / 2 - 1;
        }

    }

    @Override
    public
    Room next () {
        if (index >= rooms.length / 2) {
            if (index + 1 <= lastIndex) {
                return rooms[index++];
            } else {
                index = 0;
                return rooms[index];
            }
        } else {
            if (index<rooms.length/2 -1){
                index++;
                return rooms[index];
            }
        }
        return null;

    }
}
