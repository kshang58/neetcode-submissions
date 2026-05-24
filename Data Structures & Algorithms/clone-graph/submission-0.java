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
        if(node == null) {
            return null;
        }

        Node newHead = new Node(node.val);
        Deque<Node> queue = new ArrayDeque<>();
        Map<Node, Node> hm = new HashMap<>();
        hm.put(node, newHead);
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nei : cur.neighbors) {
                if (!hm.containsKey(nei)) {
                    Node newNei = new Node(nei.val);
                    hm.put(nei, newNei);
                    queue.offer(nei);
                }
                hm.get(cur).neighbors.add(hm.get(nei));
            }
        }
        return newHead;
    }
}