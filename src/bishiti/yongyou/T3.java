package bishiti.yongyou;

import java.util.Deque;
import java.util.LinkedList;

public class T3 {


//    [50, 30, 80, 30, 27, 57]
//    [3,3,5,4,4,4]

    public int[] findBuilding(int[] heights) {
        // write code here
        int[] ans = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right = i + 1;
            int leftMax, rightMax;
            int cur = 1;
            if (left >= 0) {
                leftMax = heights[left];
                while (left >= 0) {
                    if (heights[left] >= leftMax) {
                        cur++;
                        leftMax = heights[left];
                    }
                    left--;
                }
            }
            if (right < heights.length) {
                rightMax = heights[right];
                while (right < heights.length) {
                    if (heights[right] >= rightMax) {
                        cur++;
                        rightMax = heights[right];
                    }
                    right++;
                }
            }

            ans[i] = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i : new T3().nextGreaterElements(new int[]{50, 30, 80, 30, 27, 57})) {
            System.out.println(i);
        }

    }

    public int[] nextGreaterElements(int[] nums) {
        int[] rsp = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peekLast()]) {
                stack.addLast(i);
            } else {
                while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()]) {
                    rsp[stack.pollLast()] = nums[i];
                }
                stack.addLast(i);
            }
        }
        while (stack.size() > 0) {
            rsp[stack.pollFirst()] = -1;
        }
        return rsp;
    }
}
