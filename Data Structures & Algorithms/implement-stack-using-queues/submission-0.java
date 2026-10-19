class MyStack {
    // 1 2 3 4
    // 2 3 4 1
    // 3 4 1 2
    // 4 1 2 3
    Queue<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i ++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
    
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i ++) {
            queue.offer(queue.poll());
        }
        int num = queue.poll();
        queue.offer(num);
        return num;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */