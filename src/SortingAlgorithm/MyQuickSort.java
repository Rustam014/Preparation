package SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MyQuickSort implements MySort {

    @Override
    public Object[] sort(Object[] array, Comparator comparator) {
        quickSort(array, 0, array.length - 1, comparator);
        return array;
    }

    @Override
    public void name() {
        System.out.println("Quick Sort results:");
    }

    private <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    private <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        T temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }

}

