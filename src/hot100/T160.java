package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 14:26
 */
public class T160 {
    /**
     * 一人走两遍,如果没有相交就为空。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        // null时也会相同
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
