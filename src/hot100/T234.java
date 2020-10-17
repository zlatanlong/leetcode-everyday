package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/15 21:39
 * 如果不考虑额外空间，则直接把数保存在数组即可。
 * 后一半翻折和前面的比
 */
public class T234 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 第二段
        ListNode newHead = reverseList(slow);

        // slow 肯定小于 fast/2
        while (newHead != null) {
            if (head.val!=newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;

    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
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

    public static void main(String[] args) {
        System.out.println(Math.log10(10));
    }
}
