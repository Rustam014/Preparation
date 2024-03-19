package SortingAlgorithm;

import java.util.Comparator;

public class MyInsertSort implements MySort {
    @Override
    public Object[] sort(Object[] array, Comparator comparator) {
        for(int i = 1; i < array.length - 1; i++) {
            for(int j = i; j > 0; j--) {
                if(comparator.compare(array[j], array[j-1]) < 0) {
                    Object tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        return array;
    }

    @Override
    public void name() {
        System.out.println("Insert Sort results:");
    }
}
