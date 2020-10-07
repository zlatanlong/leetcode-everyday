package jzoffer.jz54;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 21:07
 */
public class Solution {

    private int count = 0;

    /**
     * -1 用来标记没用的结点，递归时候如果取到想要的值就一直返回它即可。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int r = kthLargest(root.right, k);
        if (r > 0) {
            return r;
        }
        count++;
        if (count == k) {
            return root.val;
        }
        int l = kthLargest(root.left, k);
        if (l > 0) {
            return l;
        }
        return -1;
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