class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val) {
            this.val = val;
        }
    }
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if (index > size - 1) return -1;
        ListNode cur = head.next;
        while (index > 0) {
            cur = cur.next;
            index --;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.prev = head;
        newHead.next = head.next;
        head.next.prev = newHead;
        head.next = newHead;
        size ++;
    }
    
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        newTail.prev = tail.prev;
        newTail.next = tail;
        tail.prev.next = newTail;
        tail.prev = newTail;
        size ++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while(index > 0) {
            cur = cur.next;
            index --;
        }
        node.next = cur.next;
        node.prev = cur;
        cur.next.prev = node;
        cur.next = node;
        size ++;
    }
    
    public void deleteAtIndex(int index) {
        if (index > size - 1) return;
        ListNode cur = head.next;
        while(index > 0) {
            cur = cur.next;
            index --;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */