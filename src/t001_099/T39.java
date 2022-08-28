package t001_099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zlatanlong
 * @date 2021/7/23 17:02
 */
public class T39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        traceBack(candidates, target, 0, ans, new ArrayList<>());

        return ans;
    }

    private void traceBack(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> cur) {
        if (0 == target) {
            ans.add(new ArrayList(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (0 > target - candidates[i]) {
                break;
            }

            cur.add(candidates[i]);

            traceBack(candidates, target - candidates[i], i, ans, cur);

            cur.remove(cur.size() - 1);
        }

    }


    public static void main(String[] args) {
        System.out.println(new T39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
