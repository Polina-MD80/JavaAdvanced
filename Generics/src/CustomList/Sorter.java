package CustomList;

public
class Sorter<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void sort (CustomList<T> customList){
        int size = customList.getSize ();
        for (int i = 0; i < size; i++) {
            T currant = customList.getElement (i);
            for (int j = i+1; j < size ; j++) {
                T next = customList.getElement (j);
                if (currant.compareTo (next)>0){
                    customList.swap (i,j);
                }
            }
        }
    }
}
