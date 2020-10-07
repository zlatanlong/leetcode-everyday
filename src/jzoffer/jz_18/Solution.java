package jzoffer.jz_18;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 15:36
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode cur = head;
        ListNode pre = dum;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // cur就是要删除的节点了
        assert cur != null;
        pre.next = cur.next;

        return dum.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}