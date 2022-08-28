package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] vals) {
        ListNode dum = new ListNode();
        ListNode cur = dum;

        for (int i = 0; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }

        return dum.next;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode cur = this;
        while (cur.next != null) {
            builder.append(cur.val + ", ");
            cur = cur.next;
        }
        builder.append(cur.val);
        builder.append("]");
        System.out.println(builder.toString());
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
