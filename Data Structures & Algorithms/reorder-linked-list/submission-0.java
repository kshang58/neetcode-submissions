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
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode midN = mid.next;
        mid.next = null;
        ListNode rev = reverse(midN);
        // cur: 1 - 2 - 3
        // rev: 5 - 4

        ListNode cur = head;
        while (rev != null) {
            ListNode nxt = cur.next;
            cur.next = rev;
            ListNode revNxt = rev.next;
            rev.next = nxt;
            cur = nxt;
            rev = revNxt;
        }
        // 1 - 5 - 2 - 4 - 3
    }
}
