class Solution {
    private class Pair {
        int temp;
        int index;
        public Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stack = new ArrayDeque<>();
        int[] rslt = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i ++) {
            Pair cur = new Pair(temperatures[i], i);
            if (stack.isEmpty() || stack.peekFirst().temp >= cur.temp) {
                stack.offerFirst(cur);
            } else {
                while (!stack.isEmpty() && stack.peekFirst().temp < cur.temp) {
                    Pair pop = stack.pollFirst();
                    rslt[pop.index] = i - pop.index;
                }
                stack.offerFirst(cur);
            }
        }
        return rslt;
    }
}
