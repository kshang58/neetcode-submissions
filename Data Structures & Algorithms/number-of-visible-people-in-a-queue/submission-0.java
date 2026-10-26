class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // stack is monotonic increasing stack.
        // 9 
        // 11
        // 5 11
        // 8 11
        // 6 8 11
        // 10 11
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i --) {
            int counter = 0;
            while (!stack.isEmpty() && stack.peekFirst() < heights[i]) {
                stack.pollFirst();
                counter ++;
            }
            result[i] = counter + (stack.isEmpty() ? 0 : 1);
            stack.offerFirst(heights[i]);
        }
        return result;
    }
}