package leetcode;

import static java.lang.Math.abs;

public class Contains_Duplicate_220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for(int i = indexDiff; i<nums.length; i++) {
            for(int j=1; j<=indexDiff; j++) {
                if(abs(nums[i] - nums[i-j]) <= valueDiff)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
        int[] nums2 = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 3));

    }
}
