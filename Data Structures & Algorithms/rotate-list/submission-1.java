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
    public ListNode rotateRight(ListNode head, int k) {
        // [1,2,3,4,5,6] k == 4
        //  fast = 6 slow = 2
        if (head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size ++;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        for (int i = 0; i < k; i ++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}