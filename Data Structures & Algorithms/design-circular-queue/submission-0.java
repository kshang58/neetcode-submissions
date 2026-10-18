class MyCircularQueue {
    int[] queue;
    int size;
    int head;
    int tail;
    int cap;

    public MyCircularQueue(int k) {
        queue = new int[k];
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if (size == cap) return false;
        queue[tail] = value;
        tail = (tail + 1) % cap;
        size ++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) return false;
        head = (head + 1) % cap;
        size --;
        return true;
    }
    
    public int Front() {
        if (size == 0) return -1;
        return queue[head];
    }
    
    public int Rear() {
        if (size == 0) return -1;
        return queue[(tail - 1 + cap) % cap];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */