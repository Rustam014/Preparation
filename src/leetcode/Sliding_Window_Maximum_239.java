package leetcode;

import java.util.*;

public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {
        int [] x = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int element : x) {
            System.out.print(element + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

}
