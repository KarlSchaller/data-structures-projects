import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class OrderedList<E extends Comparable<E>> implements Iterable<E> {

    /** A list to contain the data. */
    private List<E> theList = new LinkedList<>();


    public E get(int index) {
        // YOUR CODE HERE
        return theList.get(index);
    }

    public Iterator<E> iterator() {
        return theList.iterator();
    }

    public void remove(E item) {
        // add your code here
        theList.remove(item);
    }

    // add an item to this list, maintaining the order of the items
    public void add(E item) {

        ListIterator<E> iterator = theList.listIterator();

        // YOUR CODE HERE
        int index = 0;
        while (iterator.hasNext() && item.compareTo(iterator.next()) > 0)
            index++;
        theList.add(index, item);
    }


    public int size() {
        // YOUR CODE HERE (1 line)
        return theList.size();
    }
}
