package SortingAlgorithm;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {25,153,-4,30,17,-6,1532};
        Comparator<Integer> comparator = Integer::compare;
        MyBubbleSort bSort = new MyBubbleSort();
        MyQuickSort qSort = new MyQuickSort();
        MyMergeSort mSort = new MyMergeSort();
        MyInsertSort iSort = new MyInsertSort();
        MySelectionSort sSort = new MySelectionSort();

        MySort[] sorts = {bSort, qSort, mSort, iSort, sSort};

        for(MySort sort: sorts) {
            sort.name();
            Integer[] result = (Integer[]) sort.sort(array, comparator);

            for(Integer a: result)
                System.out.println(a);
        }
    }
}
