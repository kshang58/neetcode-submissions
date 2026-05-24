class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerFirst(val);
        if (min.isEmpty() || val < min.peekFirst()) {
            min.offerFirst(val);
        } else {
            min.offerFirst(min.peekFirst());
        }
    }
    
    public void pop() {
        stack.pollFirst();
        min.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return min.peekFirst();
    }
}
