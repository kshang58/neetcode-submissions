/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node level = root;
        while (level.left != null) {
            Node cur = level;
            while (cur != null) {
                // same tree
                cur.left.next = cur.right;
                // neighbor tree
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            // finish the current level
            level = level.left;
        }
        return root;
    }
}




