class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 8; i ++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur > high) {
                break;
            }
            if (cur >= low) {
                result.add(cur);
            }
            if (cur % 10 != 9) {
                int next = cur * 10 + cur % 10 + 1;
                queue.offer(next);
            }
        }
        return result;
    }
}