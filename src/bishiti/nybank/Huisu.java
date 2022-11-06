package bishiti.nybank;

import java.util.LinkedList;
import java.util.List;

public class Huisu {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

//        if (track.size() == nums.length) {
//            res.add(new LinkedList(track));
//            return;
//        }
        // 回溯算法标准框架
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            used[i] = true;
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums);
            // 撤销选择
            used[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Huisu huisu = new Huisu();
        for (List<Integer> subset : huisu.subsets(new int[]{1, 1, 2})) {
            System.out.print("[ ");
            for (Integer i : subset) {
                System.out.print(i+" ");
            }
            System.out.println("]");
        }

    }
}
