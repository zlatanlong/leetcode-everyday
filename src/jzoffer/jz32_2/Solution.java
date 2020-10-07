package jzoffer.jz32_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 16:05
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> curCen = new LinkedList<>();
        curCen.addFirst(root);
        while (!curCen.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            LinkedList<TreeNode> nextCen = new LinkedList<>();
            while (!curCen.isEmpty()) {
                TreeNode treeNode = curCen.removeLast();
                if (treeNode == null) {
                    continue;
                }
                l.add(treeNode.val);
                nextCen.addFirst(treeNode.left);
                nextCen.addFirst(treeNode.right);
            }
            if (!l.isEmpty()) {
                res.add(l);
            }
            curCen = nextCen;
        }
        return res;
    }

    private TreeNode head;

    public void insert(Integer[] arr) {
        LinkedList<TreeNode> l = new LinkedList<>();
        int i = 0;
        if (arr.length > i && arr[i] != null) {
            this.head = new TreeNode(arr[i++]);
            l.addFirst(head);
        }
        while (!l.isEmpty()) {
            TreeNode cur = l.removeLast();
            if (i < arr.length) {
                if (arr[i] == null) {
                    cur.left = null;
                } else {
                    cur.left = new TreeNode(arr[i]);
                    l.addFirst(cur.left);
                }
                i++;
            }
            if (i < arr.length) {
                if (arr[i] == null) {
                    cur.right = null;
                } else {
                    cur.right = new TreeNode(arr[i]);
                    l.addFirst(cur.right);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert(new Integer[]{3, 9, 20, null, null, 15, 7});
        solution.levelOrder(new TreeNode(0));
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