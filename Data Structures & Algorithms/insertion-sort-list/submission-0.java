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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode before = dummy;
            ListNode after = dummy.next;
            while (after.val < head.val) {
                before = after;
                after = after.next;
            }
            if (after == head) {
                prev = head;
                head = head.next;
                continue;
            }
            ListNode nxt = head.next;
            before.next = head;
            head.next = after;
            prev.next = nxt;
            head = nxt;
        }
        return dummy.next;
    }
}