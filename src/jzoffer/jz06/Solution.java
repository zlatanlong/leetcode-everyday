package jzoffer.jz06;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/6 15:51
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        List<Integer> l = new ArrayList<>();
        this.helper(head,l);
        return l.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void helper(ListNode head, List<Integer> list) {
        if (head==null) {
            return;
        }
        helper(head.next,list);
        list.add(head.val);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}