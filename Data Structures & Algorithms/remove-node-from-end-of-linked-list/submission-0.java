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
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode nxt = cur.next;
        ListNode newHead = reverse(nxt);
        nxt.next = cur;
        cur.next = null;
        return newHead;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode rev = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = rev;
        ListNode cur = dummy;
        // 4 - 3 - 2 - 1
        for (int i = 1; i < n; i ++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode revAgain = reverse(dummy.next);
        return revAgain;
    }
}
