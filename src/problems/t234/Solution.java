package problems.t234;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 12:31
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newRight = reverseList(slow);
        fast = head;
        while (fast.next!=slow) {
            if (fast.val!=newRight.val) return false;
            fast = fast.next;
            newRight = newRight.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}