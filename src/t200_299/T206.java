package t200_299;


import util.ListNode;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/15 17:59
 */
public class T206 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 运行到这里 cur 指的是最后一个节点的next了已经，cur为空
        // pre即为可求
        return pre;
    }

}
