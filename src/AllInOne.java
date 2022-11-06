import java.util.*;

public class AllInOne {


    //==================================================================================================================
    //9. 回文数
    private int t9_x;

    public int getNum(int index) {
        return (t9_x / (int) Math.pow(10, index - 1)) % 10;
    }

    public int getLen(int x) {
        return x < 10 ? 1 : getLen(x / 10) + 1;
    }

    public boolean isPalindrome(int x) {
        this.t9_x = x;
        if (x < 0) return false;
        int len = getLen(x);
        for (int i = 1; i <= len / 2; i++) {
            if (getNum(i) != getNum(len + 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //==================================================================================================================
    // 15. 三数之和
    // 排序 + 双指针， 固定一个先

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] < 0 && nums[nums.length - 1] > 0 || nums[0] == 0 && nums[nums.length - 1] == 0) {
            for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { // i 先确定一个数
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] == 0) {
                        ans.add(Arrays.asList(new Integer[]{nums[i], nums[l], nums[r]}));
                        //System.out.println("i: "+i+"l: "+l+"r: "+r);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                    while (l < r && nums[l] + nums[r] + nums[i] < 0) {
                        l++;
                    }
                    while (l < r && nums[l] + nums[r] + nums[i] > 0) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    //==================================================================================================================
    // 739. 每日温度
    // 维护一个单调递减的栈
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]) {
                Integer index = stack.removeLast();
                ans[index] = i - index;
            }
            stack.addLast(i);
        }
        return ans;
    }

    //==================================================================================================================
    // 1208 尽可能使字符串相等
    // 满足和小于 maxCost 的滑动窗口长度
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < n; end++){
            sum += diff[end]; // 先移动窗口前哨
            while (sum > maxCost) { // 再跟上窗口后头
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


}
