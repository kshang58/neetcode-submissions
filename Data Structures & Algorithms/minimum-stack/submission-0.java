class MinStack {
    // 5 2 1 4 7 3
    // 5 2 1 1 1 
    Deque<Integer> stack;
    List<Integer> minList;
    public MinStack() {
        stack = new ArrayDeque<>();
        minList = new ArrayList<>();
        minList.add(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        int curMin = minList.get(minList.size() - 1);
        if (val < curMin) {
            minList.add(val);
        } else {
            minList.add(curMin);
        }
        stack.offerFirst(val);
    }
    
    public void pop() {
        minList.remove(minList.size() - 1);
        stack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
