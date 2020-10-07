package jzoffer.jz27;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 16:47
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {

        helper(root);

        return root;
    }

    public void helper(TreeNode root) {
        if (root==null) {
            return;
        }
        helper(root.left);
        helper(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}