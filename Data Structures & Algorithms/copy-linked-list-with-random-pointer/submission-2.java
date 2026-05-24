/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> hm = new HashMap<>();
        Node newHead = new Node(head.val);
        hm.put(head, newHead);
        while (head != null) {
            Node cur = hm.get(head);
            if (head.next != null) {
                Node newNext = null;
                if (hm.containsKey(head.next)) {
                    newNext = hm.get(head.next);
                } else {
                    newNext = new Node(head.next.val);
                    hm.put(head.next, newNext);
                }
                cur.next = newNext;
            }
            if (head.random != null) {
                Node newRand = null;
                if (hm.containsKey(head.random)) {
                    newRand = hm.get(head.random);
                } else {
                    newRand = new Node(head.random.val);
                    hm.put(head.random, newRand);
                }
                cur.random = newRand;
            }
            head = head.next;
        }
        return newHead;
    }
}
