package jzoffer.jz35;

import java.util.HashMap;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 15:52
 */
public class Solution {
    public int getLength(Node head) {
        return head == null ? 0 : getLength(head.next) + 1;
    }

    public Node copyRandomList(Node head) {
        int length = getLength(head);
        Node dummy = new Node(0, null, null);
        Node cur = dummy;
        Node ori = head;
        for (int i = 0; i < length; i++) {
            cur.next = new Node(ori.val, null, null);
            ori = ori.next;
            cur = cur.next;
        }
        ori = head;
        cur = dummy.next;
        for (int i = 0; i < length; i++) {
            if (ori.random == null) {
                ori = ori.next;
                cur = cur.next;
                continue;
            }
            Node oriRandom = ori.random;
            Node tmp = dummy.next;
            Node tmpOri = head;
            while (tmpOri != oriRandom) {
                tmpOri = tmpOri.next;
                tmp = tmp.next;
            }
            cur.random = tmp;
            ori = ori.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 师徒，根据师父的关系，找到徒弟的关系，nb之作
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); //创建HashMap集合
        Node cur = head;
        //复制结点值
        while (cur != null) {
            //存储put:<key,value1>
            map.put(cur, new Node(cur.val, null, null)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur = cur.next;
        }
        //复制结点指向
        cur = head;
        while (cur != null) {
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }
        //返回复制的链表
        return map.get(head);
    }

    /**
     * dfs
     *
     * @param head
     * @return
     */
    public Node copyRandomList3(Node head) {
        // k-v: 老的，新的
        HashMap<Node, Node> memo = new HashMap<>();
        return dfs(head, memo);
    }

    public Node dfs(Node head, HashMap<Node, Node> memo) {
        if (head == null) {
            return null;
        }
        if (memo.containsKey(head)) {
            return memo.get(head);
        }

        Node node = new Node(head.val, null, null);
        memo.put(head, node);
        node.next = dfs(head.next, memo);
        node.random = dfs(head.random, memo);
        return node;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//[[3,null],[5,17],[4,null],[-9,6],[-10,3],[5,15],[0,11],[6,null],[-6,16],[3,16],[-6,11],[9,12],[-2,1],[-3,11],[-1,10],[2,11],[-3,null],[-9,7],[-2,4],[-8,null],[5,null]]