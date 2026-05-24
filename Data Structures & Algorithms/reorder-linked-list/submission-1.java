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
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public void reorderList(ListNode head) {
        // find mid, cut in half, reverse the second half, then merge
        ListNode mid = findMid(head);
        ListNode midN = mid.next;
        mid.next = null;
        ListNode midNR = reverse(midN);
        ListNode cur = head;
        // head : 0 1 2 3
        // midNR: 6 5 4
        while (cur != null) {
            ListNode curN = cur.next;
            cur.next = midNR;
            cur = cur.next;
            midNR = curN;
        }
    }
}
