public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    private int cap;
    private Map<Integer, Node> hm;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.hm = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        right.prev = left;
        left.next = right;
    }
    
    public int get(int key) {
        if(this.hm.containsKey(key)) {
            Node cur = this.hm.get(key);
            update(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    private void update(Node cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = this.right.prev;
        cur.next = this.right;
        this.right.prev.next = cur;
        this.right.prev = cur;
    }
    
    public void put(int key, int value) {
        if(this.hm.containsKey(key)) {
            Node cur = this.hm.get(key);
            cur.val = value;
            update(cur);
            return;
        } else {
            Node newNode = new Node(key, value);
            int curNum = this.hm.size();
            newNode.prev = this.right.prev;
            newNode.next = this.right;
            this.right.prev.next = newNode;
            this.right.prev = newNode;
            this.hm.put(key, newNode);
            if (curNum == this.cap) {
                Node exit = this.left.next;
                exit.next.prev = this.left;
                this.left.next = exit.next;
                hm.remove(exit.key);
            }
        }
    }
}
