package classes;
import java.util.Iterator;

public class MyListIterator implements Iterator<Integer> {
    Node current;

    // initialize pointer to head of the list for iteration
    public MyListIterator(Node first)
    {
        current = first;
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public Integer next()
    {
        Integer data = current.getInfo();
        current = current.getNext();
        return data;
    }
}
