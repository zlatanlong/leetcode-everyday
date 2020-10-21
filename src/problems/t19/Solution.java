package problems.t19;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/18 11:18
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode fast = dum;
        // 快指针先跑n次
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        ListNode slow = dum;
        // 快指针下一个为空时
        // 快指针是最后一个，即倒数 1 个
        // 慢指针是倒数 n + 1 个
        // 它的下一个就是要删除的倒数第 n 个
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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