class Solution {
    class Pair {
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
            if (stack.isEmpty() || stack.peekFirst().height < heights[i]) {
                stack.offerFirst(new Pair(i, heights[i]));
            } else {
                int position = i;
                while (!stack.isEmpty() && stack.peekFirst().height > heights[i]) {
                    Pair cur = stack.pollFirst();
                    globalMax = Math.max(globalMax, cur.height * (i - cur.index));
                    position = cur.index;
                }
                stack.offerFirst(new Pair(position, heights[i]));
            }
        }
        while (!stack.isEmpty()) {
            Pair cur = stack.pollFirst();
            globalMax = Math.max(globalMax, cur.height * (heights.length - cur.index));
        }
        return globalMax;
    }
}
