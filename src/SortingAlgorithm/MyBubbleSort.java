package SortingAlgorithm;

import java.util.Comparator;

public class MyBubbleSort implements MySort {
    @Override
    public Object[] sort(Object[] array, Comparator comparator) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (comparator.compare(array[j], array[j - 1]) < 0) {
                    Object temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    @Override
    public void name() {
        System.out.println("Bubble Sort results:");
    }
}
