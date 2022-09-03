package jzoffer.jz28;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zlatanlong
 * @date 2020/10/3 18:37
 * 递归迭代都需要掌握
 */
public class Solution {


    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && dfs(left.right, right.left) && dfs(left.left, right.right);
    }

    /**
     * 迭代方法
     * @param left
     * @param right
     * @return
     */
    public boolean diedai(TreeNode left, TreeNode right) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(left);
        deque.addLast(right);
        while (!deque.isEmpty()) {
            TreeNode l = deque.removeLast();
            TreeNode r = deque.removeLast();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            deque.addLast(l.left);
            deque.addLast(r.right);

            deque.addLast(l.right);
            deque.addLast(r.left);
        }
        return true;
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
