package SortingAlgorithm;

import java.util.Comparator;

public class MySelectionSort implements MySort {
    @Override
    public Object[] sort(Object[] array, Comparator comparator) {
        for(int start = 0; start < array.length - 1; start++) {
            int indexMin = findMin(array, start, comparator);
            Object tmp = array[start];
            array[start] = array[indexMin];
            array[indexMin] = tmp;
        }

        return array;
    }

    private int findMin(Object[] array, int start, Comparator comparator) {
        Object min = array[array.length - 1];
        int indexMin = array.length - 1;
        for(; start < array.length - 1; start++) {
            if(comparator.compare(min, array[start]) > 0) {
                min = array[start];
                indexMin = start;
            }
        }
        return indexMin;
    }

    @Override
    public void name() {
        System.out.println("Selection Sort results");
    }
}
