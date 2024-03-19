package yandex;
import java.util.Scanner;
public class BeautifulString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int changes = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();


        int[] count = new int[26];
        int maxCount = 0, start = 0, maxBeauty = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            count[currentChar - 'a']++;

            maxCount = Math.max(maxCount, count[currentChar - 'a']);

            int windowLength = end - start + 1;
            if (windowLength - maxCount > changes) {
                char startChar = s.charAt(start);
                count[startChar - 'a']--;
                start++;
            }

            maxBeauty = Math.max(maxBeauty, windowLength);
        }

        System.out.println(maxBeauty - 1);
    }
}
