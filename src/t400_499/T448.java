package t400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 15:42
 */
public class T448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new T448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }


}
