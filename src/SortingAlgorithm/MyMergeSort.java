package SortingAlgorithm;

import java.util.Comparator;

public class MyMergeSort implements MySort {
    @Override
    public Object[] sort(Object[] array, Comparator comparator) {
        mergeSort(array, 0, array.length / 2, array.length / 2 + 1, array.length, comparator);
        return array;
    }

    @Override
    public void name() {
        System.out.println("Merge Sort results:");
    }

    private void mergeSort(Object[] array, int start1, int end1, int start2, int end2, Comparator comparator) {
        if((end1 / 2) - start1 > 2) {
            mergeSort(array, start1, end1 / 2, end1 / 2 + 1, end1, comparator);
            mergeSort(array, start2, end2 / 2, end2 / 2 + 1, end2, comparator);
            merge(array, start1, end1, start2, end2, comparator);
        }

    }

    private void merge(Object[] array, int start1, int end1, int start2, int end2, Comparator comparator) {
        int j = start2;
        int x = 0;
        Object[] res = new Object[end1 - start1 + end2 - start2 + 1];
        for(int i = start1; i < end1+end2; i++) {
            if(comparator.compare(array[i], array[j]) > 0) {
                res[x] = array[j];
                j++;
                i--;
            }
            else {
                res[x] = array[i];
            }
            x++;
        }
        x = 0;
        for(int i = start1; i < end2; i++) {
            array[i] = res[x];
            x++;
        }
    }
}
