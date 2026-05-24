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
        int flowover = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        while (l1 != null || l2 != null || flowover != 0) {
            int l1v = l1 == null ? 0 : l1.val; 
            int l2v = l2 == null ? 0 : l2.val;
            ListNode cur = new ListNode((l1v + l2v + flowover) % 10);
            flowover = (l1v + l2v + flowover) / 10;
            pointer.next = cur;
            pointer = pointer.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
