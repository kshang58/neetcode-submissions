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
            if (stack.isEmpty() || stack.peekLast().temp >= temperatures[i]) {
                stack.offerLast(new Pair(temperatures[i], i));
            } else {
                while (!stack.isEmpty() && stack.peekLast().temp < temperatures[i]) {
                    Pair cur = stack.pollLast();
                    rslt[cur.index] = i - cur.index;
                }
                stack.offerLast(new Pair(temperatures[i], i));
            }
        }
        while (!stack.isEmpty()) {
            Pair cur = stack.pollLast();
            rslt[cur.index] = 0;
        }
        return rslt;
    }
}
