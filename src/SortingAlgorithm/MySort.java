package SortingAlgorithm;

import java.util.Comparator;

public interface MySort<T> {
    T[] sort(T[] array, Comparator<? super T> comparator);
    void name();
}
