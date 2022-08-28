package t001_099;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlatanlong
 * @date 2021/8/6 22:03
 */
public class T22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(n, n, "", ans);
        System.out.println(ans);
        return ans;
    }

    public void dfs(int left, int right, String cur, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(cur);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, cur + "(", ans);
        }
        if (right > 0) {
            dfs(left, right - 1, cur + ")", ans);
        }

    }

    public static void main(String[] args) {
        T22 t22 = new T22();
        t22.generateParenthesis(2);
    }
}
