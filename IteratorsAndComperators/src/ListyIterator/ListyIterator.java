package ListyIterator;

import java.util.Iterator;
import java.util.List;

public
class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public
    ListyIterator (List<String> data) {
        this.data = data;
        if (!data.isEmpty ()) {
            this.index = 0;
        } else {
            index = -1;
        }
    }

    public
    boolean move () {
        if (this.index < this.data.size () - 1) {
            this.index++;
            return true;
        } else return false;
    }

    public
    String print () {
        if (this.index == -1) {
            return "Invalid Operation!";
        } else {
            return this.data.get (this.index);
        }
    }

    public
    boolean hasNext () {
        return this.index != -1 && this.index < this.data.size () - 1;
    }

    @Override
    public
    Iterator<String> iterator () {
        return new Iterator<String> () {
            private int index = 0;

            @Override
            public
            boolean hasNext () {
                return this.index <= data.size () - 1;
            }

            @Override
            public
            String next () {
                return data.get (index++);
            }
        };
    }
}
