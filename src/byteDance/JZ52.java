package byteDance;

import java.util.ArrayDeque;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/2 16:36
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class JZ52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayDeque<ListNode> deque1 = new ArrayDeque<>();
        ArrayDeque<ListNode> deque2 = new ArrayDeque<>();

        while (headA != null) {
            deque1.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            deque2.push(headB);
            headB = headB.next;
        }

        ListNode lastNode = null;
        while (deque1.peek() != null && deque2.peek() != null && deque1.peek() == deque2.peek()) {
            lastNode = deque1.pop();
            deque2.pop();
        }

        return lastNode;
    }

    /**
     * 双指针解法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }

}