package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Word_Pattern_290 {
    public static void main(String[] args) {
        if(wordPattern("abba", "dog cat cat dog"))
            System.out.println("true");
        else System.out.println("false");
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] wordsArray = s.split(" ");
        List<String> d = Arrays.asList(wordsArray);

        Map<Character, String> coincidences = new HashMap<>();
        Stream<String> keys = Stream.of(pattern);
        for(int i=0; i<d.size(); i++)
        {
            if(coincidences.containsKey( pattern.charAt(i) ))
            {
                if(! d.get(i).equals( coincidences.get( pattern.charAt(i) )))
                    return false;
            }
            else
                coincidences.put(pattern.charAt(i), d.get(i));
        }
        return true;
    }
}
