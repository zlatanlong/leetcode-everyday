package mianshi;

public class MS0803 {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    /**
     * @param nums  原数组
     * @param left  左端点
     * @param right 右端点
     * @return -1 说明到左端点了
     */
    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        // 首先第一步 一直往左二分
        int answer = getAnswer(nums, left, mid - 1);
        if (answer != -1) {
            return answer;
        } else if (mid == nums[mid]) {
            return mid;
        } else {
            return getAnswer(nums, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int a = (1 - 0) / 2;
        System.out.println(a);
    }
}
