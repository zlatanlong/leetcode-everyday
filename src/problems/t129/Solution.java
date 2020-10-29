package problems.t129;

/**
 * Solution
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, 0);
    }

    public int helper(TreeNode root, int curRes) {
        curRes = curRes * 10 + root.val;
        if (root.right == null && root.left == null) {
            return curRes;
        }
        int ans = 0;
        if (root.left != null)
            ans += helper(root.left, curRes);
        if (root.right != null)
            ans += helper(root.right, curRes);
        return ans;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}