class MyQueue {
    // 5 6 7 8
    // 
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.offerFirst(x);
    }
    
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pollFirst();
        }
        while (!stack1.isEmpty()) {
            stack2.offerFirst(stack1.pollFirst());
        }
        return stack2.pollFirst();
    }
    
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peekFirst();
        }
        while (!stack1.isEmpty()) {
            stack2.offerFirst(stack1.pollFirst());
        }
        return stack2.peekFirst();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */