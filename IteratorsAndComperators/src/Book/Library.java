package Book;

import java.util.Iterator;
import java.util.List;

public
class Library implements Iterable<Book>{
    private Book[] books;
    public Library(Book... book){
        this.books = book;
    }

    private  class LibIterator implements Iterator<Book>{
        private int index;
        public LibIterator(){
            this.index=0;
        }
        @Override
        public
        boolean hasNext () {
            return this.index< books.length;
        }

        @Override
        public
        Book next () {
            return books[index++];
        }
    }
    @Override
    public
    Iterator<Book> iterator () {

        return new LibIterator();
    }
}
