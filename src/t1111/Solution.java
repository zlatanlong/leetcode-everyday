package t1111;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            // 把左右括号按奇偶分配
            if (c == '(') {
                ans[idx++] = idx & 1;
            } else {
                ans[idx++] = (idx + 1) & 1;
            }
//            ans[idx++] = (c == '(' ? idx & 1 : ((idx + 1) & 1));
        }
        return ans;
    }

    public static void main(String[] args) {
//        String seq = "(()())";
//        Solution solution = new Solution();
//        int[] temp = solution.maxDepthAfterSplit(seq);
//        for (int i : temp) {
//            System.out.print(i);
//        }
        System.out.println(1&1);
    }
}
