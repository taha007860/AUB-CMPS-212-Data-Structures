package Pr1;

import java.util.Comparator;
public class DefaultComparator1<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
