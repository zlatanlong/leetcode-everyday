package jzoffer.jz55_2;


/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 14:49
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
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