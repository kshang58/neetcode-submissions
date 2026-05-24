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
        Map<Node, Node> hm = new HashMap<>();
        Node cur = head;
        // first pass to copy all node and map in hashmap
        while(cur != null) {
            Node newNode = new Node(cur.val);
            hm.put(cur, newNode);
            cur = cur.next;
        }
        // second pass to make all pointers
        cur = head;
        while(cur != null) {
            Node newCur = hm.get(cur);
            if (cur.next != null) {
                Node newNext = hm.get(cur.next);
                newCur.next = newNext;
            }
            if (cur.random != null) {
                Node newRand = hm.get(cur.random);
                newCur.random = newRand;
            }
            cur = cur.next;
        }
        return hm.get(head);
    }
}
