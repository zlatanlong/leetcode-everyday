package t001_099;

import util.ListNode;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/20 22:13
 */
public class T21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummp = new ListNode();
        ListNode cur = dummp;

        while (l1 != null && l2 != null) {
            if (l1.val<= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return dummp.next;
    }
}
