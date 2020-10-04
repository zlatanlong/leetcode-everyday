package jzoffer.jz22;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 15:44
 */
public class Solution {

    public int getLength(ListNode head) {
        return head == null ? 0 : getLength(head.next) + 1;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = getLength(head);

        for (int i = 0; i < length - k; i++) {
            head=head.next;
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}