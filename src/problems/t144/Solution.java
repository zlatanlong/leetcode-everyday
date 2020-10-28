package problems.t144;

import java.util.*;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/27 16:57
 */
public class Solution {


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.left!=null) {
                stack.push(pop.left);
            }
            if (pop.right!=null) {
                stack.push(pop.right);
            }
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}