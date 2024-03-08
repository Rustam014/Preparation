package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Integer_to_English_Words_273 {

    static Map<Integer, String> words = new HashMap<>();

    public static void main(String[] args) {
        Inicialization();
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
    }

    private static void Inicialization() {
        words.put(1, "One");
        words.put(2, "Two");
        words.put(3, "Three");
        words.put(4, "Four");
        words.put(5, "Five");
        words.put(6, "Six");
        words.put(7, "Seven");
        words.put(8, "Eight");
        words.put(9, "Nine");
        words.put(10, "Ten");
        words.put(11, "Eleven");
        words.put(12, "Twelve");
        words.put(13, "Thirteen");
        words.put(20, "Twenty");
        words.put(30, "Thirty");
        words.put(40, "Forty");
        words.put(100, "Hundred");
        words.put(1000, "Thousandth");
        words.put(1000000, "Million");

        words.put(14, words.get(4)+"teen");
        for(int i=5; i<10; i++) {
            words.put(i+10, words.get(i)+"teen");
            words.put(i*10, words.get(i)+"ty");
        }
    }

    public static String numberToWords(int num) {
        return recursion(num, 1);
    }

    public static String recursion(int num, int exponent) {
        if(num<1000)
            return func(num) + " " + (exponent==1 ? "" : words.get(exponent));
        int threenum = num%1000;
        int rest = num/1000;
        String res = recursion(rest, exponent*1000);
        return res+func(threenum) + " " + (exponent==1 ? "" : words.get(exponent)) ;
    }

    public static String func(int num) {
        String res = "";
        int hund = num/100;
        int tens = num%100;
        if(hund > 0) {
            res += " " + words.get(hund) + " " + words.get(100);
        }
        if(tens > 0) {
            if(tens > 20 && tens%10>0) res += " " + words.get(tens - tens%10) + " " + words.get(tens%10);
            else res += " " + words.get(tens);
        }

        return res;
    }
}
