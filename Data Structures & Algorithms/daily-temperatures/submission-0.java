class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i ++) {
            if (stack.isEmpty() || temperatures[stack.peekFirst()] >= temperatures[i]) {
                stack.offerFirst(i);
            } else {
                while(!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                    int index = stack.pollFirst();
                    temperatures[index] = i - index;
                }
                stack.offerFirst(i);
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pollFirst();
            temperatures[index] = 0;
        }
        return temperatures;
    }
}
