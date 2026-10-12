class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int globalMax = 0;
        for (int i = 0; i < heights.length; i ++) {
            if (stack.isEmpty()) stack.offerFirst(new int[]{heights[i], i});
            if (!stack.isEmpty() && stack.peekFirst()[0] <= heights[i]) {
                stack.offerFirst(new int[]{heights[i], i});
            } else {
                int leftBound = 0;
                while (!stack.isEmpty() && stack.peekFirst()[0] > heights[i]) {
                    int[] pop = stack.pollFirst();
                    globalMax = Math.max(globalMax, pop[0] * (i - pop[1]));
                    leftBound = pop[1];
                }
                stack.offerFirst(new int[]{heights[i], leftBound});
            }
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pollFirst();
            globalMax = Math.max(globalMax, pop[0] * (heights.length - pop[1]));
        }
        return globalMax;
    }
}
