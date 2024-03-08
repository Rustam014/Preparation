package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Peeking_Iterator_284 implements Iterator<Integer> {
    List<Integer> array = new ArrayList<>();
    Integer index = 0;
    public Peeking_Iterator_284(Iterator<Integer> iterator) {
        iterator.forEachRemaining(e -> array.add(e));
        for(Integer a: array) {
            System.out.println(a);
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return array.get(index);
    }

    @Override
    public Integer next() {
        return array.get(index++);
    }

    @Override
    public boolean hasNext() {
        if(index < array.size()) return true;
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1,2,3);
        Iterator<Integer> it = array.iterator();
        Peeking_Iterator_284 a = new Peeking_Iterator_284(it);
        System.out.println(a.peek());
        System.out.println(a.next());
        System.out.println(a.peek());
        System.out.println(a.next());
        System.out.println(a.next());
    }
}