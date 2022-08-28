package t200_299;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/16 16:06
 */
public class T283 {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = 0; i < count; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }

    public static void main(String[] args) {
        new T283().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
