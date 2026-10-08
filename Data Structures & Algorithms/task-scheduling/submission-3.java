class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            maxHeap.offer(e.getValue());
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int timestamp = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek()[1] <= timestamp) {
                int[] cur = queue.poll();
                maxHeap.offer(cur[0]);
            }
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                if (task > 1) {
                    queue.offer(new int[]{task - 1, timestamp + n + 1});
                }
            }
            timestamp ++;
        }
        return timestamp;
    }
}