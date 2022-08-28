package util;

public class BinarySearch {


    public static int left(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (tar >= nums[m])
                l = m + 1;
            else {
                r = m;
            }
        }

        return r;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9};

        int i = BinarySearch.left(nums, 0);
        System.out.println(nums[i]);


    }
}
