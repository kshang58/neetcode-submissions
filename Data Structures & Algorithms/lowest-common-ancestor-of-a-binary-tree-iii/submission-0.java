/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    private int height(Node node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.parent;
        }
        return h;
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        int h1 = height(p);
        int h2 = height(q);
        if (h2 < h1) {
            Node temp = p;
            p = q;
            q = temp;
            int th = h1;
            h1 = h2;
            h2 = th;
        }
        int diff = h2 - h1;
        while (diff > 0) {
            q = q.parent;
            diff --;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return q;
    }
}