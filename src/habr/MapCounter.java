package habr;

import java.util.HashMap;
import java.util.Map;

public class MapCounter {
    public static <K> Map<K, Integer> countValues(K[] ks) {
        Map<K, Integer> map = new HashMap<>();
        for (K k : ks) {
            map.compute(k, (k1, count) -> count == null ? 1 : count + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,1,2,3,4,1,2,3,1,2};
        countValues(array).forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
