class Solution {
    public int leastInterval(char[] tasks, int n) {
        // use a map to record the number of each tasks
        // eg. A - 3, B - 1, C - 1
        // Use a maxHeap to get the most frequest tasks
        // after finish one task, put into a queue for wait
        Map<Character, Integer> hm = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> queue = new ArrayDeque<>();
        for (char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (int i : hm.values()) {
            maxHeap.offer(i);
        }
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int[] cur = queue.peek();
                if (cur[1] < time) {
                    maxHeap.offer(cur[0]);
                    queue.poll();
                } else {
                    break;
                }
            }
            if (!maxHeap.isEmpty()) {
                int num = maxHeap.poll();
                num = num - 1;
                if (num > 0) {
                    queue.offer(new int[]{num, time + n});
                }
            }
            time ++;
        }
        return time;
    }
}
