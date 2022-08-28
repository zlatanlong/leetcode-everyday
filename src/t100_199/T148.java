package t100_199;

import util.ListNode;

/**
 * @author zlatanlong
 * @date 2021/8/11 10:35
 */
public class T148 {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode fast = dum;
        ListNode slow = dum;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dum = new ListNode();
        ListNode cur = dum;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.build(new int[]{1, 3, 5, 7, 2, 4, 6, 7});
        ListNode node2 = ListNode.build(new int[]{2, 4, 6, 8, 10});
        ListNode merge = new T148().sortList(node1);
        merge.print();
    }
}
