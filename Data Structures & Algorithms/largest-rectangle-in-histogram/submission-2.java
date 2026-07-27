class Solution {
    private class Pair {
        int index;
        int height;
        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack = new ArrayDeque<>();
        int globalMax = 0;
        for (int i = 0; i < heights.length; i ++) {
            Pair cur = new Pair(i, heights[i]);
            if (stack.isEmpty() || stack.peekFirst().height <= cur.height) {
                stack.offerFirst(cur);
            } else {
                int position = i;
                while(!stack.isEmpty() && stack.peekFirst().height > cur.height) {
                    Pair pop = stack.pollFirst();
                    globalMax = Math.max(globalMax, pop.height * (i - pop.index));
                    position = pop.index;
                }
                stack.offerFirst(new Pair(position, cur.height));
            }
        }
        while (!stack.isEmpty()) {
            Pair pop = stack.pollFirst();
            globalMax = Math.max(globalMax, pop.height * (heights.length - pop.index));
        }
        return globalMax;
    }
}
