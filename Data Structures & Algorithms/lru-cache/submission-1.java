class LRUCache {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, ListNode> cache;
    int capacity;
    ListNode head;
    ListNode tail;
    int size;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(2000, 0);
        tail = new ListNode(2000, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void update(ListNode cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = head;
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
    }
    public int get(int key) {
        int rslt = -1;
        if (cache.containsKey(key)) {
            ListNode cur = cache.get(key);
            rslt = cur.val;
            update(cur);
        }
        return rslt;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode cur = cache.get(key);
            cur.val = value;
            update(cur);
        } else {
            ListNode ncur = new ListNode(key, value);
            cache.put(key, ncur);
            ncur.next = head.next;
            ncur.prev = head;
            head.next.prev = ncur;
            head.next = ncur;
            size ++;
            if (size > capacity) {
                int eli = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                size --;
                cache.remove(eli);
            }
        }
    }
}
