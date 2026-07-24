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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        for (ListNode l : lists) {
            minHeap.offer(l);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            if (top.next != null) {
                minHeap.offer(top.next);
            }
            cur.next = top;
            cur = cur.next;
        }
        return dummy.next;
    }
}
