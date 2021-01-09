package Book;

import java.util.Comparator;

public
class BookComparator implements Comparator<Book> {
    @Override
    public
    int compare (Book first, Book second) {
       int compareResult = first.getTitle ().compareTo (second.getTitle ());
       if (compareResult==0){
           compareResult = Integer.compare (first.getYear (), second.getYear ());

       }
     return compareResult;
    }
}
