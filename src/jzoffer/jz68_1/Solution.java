package jzoffer.jz68_1;


/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 21:46
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val), min = Math.min(p.val, q.val);
        if (root == null) {
            return null;
        }
        int cur = root.val;
        if (cur >= min && cur <= max) {
            return root;
        }
        if (cur > max) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
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