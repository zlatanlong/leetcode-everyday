package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int[] vals) {
        if (vals.length == 0) return;
        val = vals[0];
        ListNode cur = this;
        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode();
            node.val = vals[i];
            cur.next = node;
            cur = node;
        }
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode merge(ListNode h1, ListNode h2) {
        ListNode dum = new ListNode();
        ListNode cur = dum;
        while (h1!=null && h2!=null) {
            cur.next = h1;
            h1 = h1.next;
            cur = cur.next;

            cur.next = h2;
            h2 = h2.next;
            cur = cur.next;
        }
        if (h1 == null) cur.next = h2;
        if (h2 == null) cur.next = h1;

        return dum.next;
    }

    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return val + " - " + super.toString();
    }

    public static void main(String[] args) {
        ListNode.merge(new ListNode(new int[]{1, 3, 5}),
                        new ListNode(new int[]{2, 4, 6,8,10}))
                .print();
    }
}
