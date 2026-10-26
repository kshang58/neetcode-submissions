class StockSpanner {
    Deque<int[]> stack;
    int index;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = 0;
    }
    // 100 80 60 70
    // 0.  1.  2. 3
    public int next(int price) {
        if (stack.isEmpty() || stack.peekLast()[0] > price) {
            stack.offerLast(new int[]{price, index});
            index ++;
            return 1;
        } else {
            while (!stack.isEmpty() && stack.peekLast()[0] <= price) {
                stack.pollLast();
            }
            int idx = -1;
            if (!stack.isEmpty()) {
                idx = stack.peekLast()[1];
            }
            stack.offerLast(new int[]{price, index});
            int span = index - idx;
            index ++;
            return span;
        }
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */