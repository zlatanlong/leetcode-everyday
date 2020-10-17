package problems.t106;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/15 15:26
 * 116. 填充每个节点的下一个右侧节点指针
 * bfs 时候每一层 要做什么事情， 通过获取队列的size知道当前层的个数
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i > 0) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }

        return root;

    }

    /**
     * 迭代的思想
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node start = root;
        Node cur;

        while (start.left != null/*说明还有一层,在当前层操作下一层，所以判断条件是下一层*/) {
            cur = start;

            while (cur != null) {
                cur.left.next = cur.right;

                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            start = start.left;
        }


        return root;

    }


}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};