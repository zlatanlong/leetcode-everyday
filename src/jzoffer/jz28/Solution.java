package jzoffer.jz28;


/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 18:37
 */
public class Solution {


    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
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