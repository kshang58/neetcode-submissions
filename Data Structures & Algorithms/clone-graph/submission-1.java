/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> hm = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node newHead = new Node(node.val);
        hm.put(node, newHead);
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node n : cur.neighbors) {
                if (!hm.containsKey(n)) {
                    Node newNei = new Node(n.val);
                    hm.put(n, newNei);
                    queue.offer(n);
                }
                hm.get(cur).neighbors.add(hm.get(n));
            }
        }
        return newHead;
    }
}