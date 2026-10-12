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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (ListNode n : lists) {
            if (n != null) minHeap.offer(n);
        }
        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            if (cur.next != null) minHeap.offer(cur.next);
            head.next = cur;
            head = head.next;
        }
        return dummy.next;
    }
}