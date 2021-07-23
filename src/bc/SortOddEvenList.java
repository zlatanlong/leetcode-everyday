package bc;

import util.ListNode;

class SortOddEvenList {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode();
        ListNode cur = dum;

        while (l1 != null && l2 != null) {
            cur.next = l1.val < l2.val ? l1 : l2;
            if (l1.val < l2.val)
                l1 = l1.next;
            else
                l2 = l2.next;
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dum.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode last = null;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }

    public ListNode sortListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode curOdd = oddHead;
        ListNode curEven = evenHead;
        // even 是下一步 因此选用even
        while (curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;

            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = null;

        ListNode reverseEvenHead = reverse(evenHead);
        ListNode merge = merge(oddHead, reverseEvenHead);

        return merge;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[]{1, 8, 5, 6, 9, 4, 13, 2});
        System.out.println(new SortOddEvenList().sortListNode(l1));
    }

}
