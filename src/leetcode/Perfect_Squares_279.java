package leetcode;

import static java.lang.Math.sqrt;

public class Perfect_Squares_279 {
    public static void main(String[] args) {
        System.out.println( numSquares(13));
    }
    public static int numSquares(int n) {
        return recursion(n, 0);
    }

    public static int recursion(int n, int count) {
        if(n==0) return count;
        if(n < 0) return 10000;
        int min = 10000;
        for(int i=1; i<=sqrt(n); i++) {
            int res = recursion(n-i*i, count+1);
            if(res<min)
                min = res;
        }
        return min;
    }
}
