package Book;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public
class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public
    Book (String title, int year, String... strings) {
        this.setTitle (title);
        this.setYear (year);
        this.setAuthors(strings);
    }

    private
    void setAuthors (String... strings) {
         this.authors = Arrays.asList (strings);
    }

    private
    void setYear (int year) {
        this.year = year;
    }

    private
    void setTitle (String title) {
        this.title = title;
    }

    public
    String getTitle () {
        return this.title;
    }

    public
    int getYear () {
        return this.year;
    }

    public
    List<String> getAuthors () {
        return this.authors;
    }


    @Override
    public
    int compareTo (Book other) {
        int compareResult = this.title.compareTo (other.title);
        if (compareResult==0){
            compareResult = Integer.compare (this.year,other.year);
        }
        return compareResult;
    }
}
