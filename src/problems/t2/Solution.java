package problems.t2;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/11 16:58
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        int flag = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + flag) % 10);
            flag = (l1.val + flag) / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + flag) % 10);
            flag = (l2.val + flag) / 10;
            cur = cur.next;
            l2 = l2.next;
        }
        cur.next = flag == 0 ? null : new ListNode(flag);
        return dum.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}