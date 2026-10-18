class MinStack {
    Deque<Integer> stack;
    Deque<int[]> minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        stack.offerFirst(value);
        if (minStack.isEmpty()) {
            minStack.offerFirst(new int[]{value, 0});
        } else {
            int curMin = minStack.peekFirst()[0];
            if (value < curMin) minStack.offerFirst(new int[]{value, stack.size() - 1});
        }
        
    }
    
    public void pop() {
        int cur = stack.pollFirst();
        int[] curMin = minStack.peekFirst();
        if (cur == curMin[0] && stack.size() == curMin[1]) minStack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst()[0];
    }
}
