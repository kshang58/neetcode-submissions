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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyS = new ListNode(-1);
        ListNode dummyB = new ListNode(-1);
        ListNode cur = head, pt1 = dummyS, pt2 = dummyB;
        while (cur != null) {
            if (cur.val < x) {
                pt1.next = cur;
                pt1 = pt1.next;
            } else {
                pt2.next = cur;
                pt2 = pt2.next;
            }
            cur = cur.next;
        }
        pt2.next = null;
        pt1.next = dummyB.next;
        return dummyS.next;
    }
}
