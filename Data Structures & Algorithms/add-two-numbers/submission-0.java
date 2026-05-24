/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        int flowover = 0;
        ListNode dummy = new ListNode(0);
        ListNode c3 = dummy;
        while(c1 != null || c2 != null || flowover != 0) {
            int cur = (c1 != null ? c1.val : 0)  + (c2 != null ? c2.val : 0) + flowover;
            flowover = cur / 10;
            cur = cur % 10;
            c3.next = new ListNode(cur);
            c3 = c3.next;
            if (c1 != null) {
                c1 = c1.next;
            }
            if (c2 != null) {
                c2 = c2.next;
            }
        }
        return dummy.next;
    }
}
