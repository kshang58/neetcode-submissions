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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1 - 2 - 3 - 4 - 5 - 6
        // 1 - 2 - 4 - 3 - 5 - 6
        int pos = 1;
        ListNode cur = head;
        ListNode prev = null;
        ListNode newTail = null;
        ListNode prevHead = null;
        ListNode newRevHead = null;
        while (cur != null) {
            if (pos < left) {
                prev = cur;
                cur = cur.next;
                pos ++;
                continue;
            }
            if (pos == left) {
                prevHead = prev;
                newTail = cur;
                prev = null;
            }
            if (pos >= left && pos <= right) {
                newRevHead = cur;
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                pos ++;
                continue;
            }
            newTail.next = cur;
            break;
        }
        if (prevHead != null) {
            prevHead.next = newRevHead;
        }
        
        return left > 1 ? head : newRevHead;
    }
}