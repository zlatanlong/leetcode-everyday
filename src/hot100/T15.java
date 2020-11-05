package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0)
            return res;
        Arrays.sort(nums);
        // 第一个和最后一个异号
        if (nums[0] <= 0 && nums[length - 1] >= 0) {
            for (int l = 0; l < length - 2;) {
                if (nums[l] > 0)
                    break; // 第一个数必须要小于等于0
                int m = l + 1;
                int r = length - 1;
                while (m < r) {
                    if (nums[r] < 0)
                        break; // 最后一个数必须大于等于0
                    int result = nums[l] + nums[m] + nums[r];
                    if (result == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[l]);
                        tmp.add(nums[m]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                    }
                    // 当前l m r成功，l 不变 动一动 m r还可能成功
                    if (result < 0) {
                        // 实力太弱，m-> 多一点
                        while (m < r && nums[m] == nums[++m]) {
                        }
                    } else {
                        // 实力太强，r<- 少一点
                        while (m < r && nums[r] == nums[--r]) {
                        }
                    }
                }
                while (l < length - 1 && nums[l] == nums[++l]) {
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        new T15().threeSum(new int[] { 0, 0, 0, 0 });
    }

}
