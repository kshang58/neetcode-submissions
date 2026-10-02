class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peekFirst()[0]) {
                int[] cur = stack.pollFirst();
                result[cur[1]] = i - cur[1];
            }
            stack.offerFirst(new int[]{temp, i});
        }
        return result;
    }
}