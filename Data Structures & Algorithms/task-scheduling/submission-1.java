class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Deque<int[]> waitList = new ArrayDeque<>();
        Map<Character, Integer> hm = new HashMap<>();
        for(char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (int i : hm.values()) {
            maxHeap.offer(i);
        }
        int time = 0;
        while(!maxHeap.isEmpty() || !waitList.isEmpty()) {
            int[] waitTop = waitList.peek();
            if (waitTop != null && waitTop[1] <= time) {
                waitList.poll();
                maxHeap.offer(waitTop[0]);
            }
            time ++;
            if (!maxHeap.isEmpty()) {
                int cur = maxHeap.poll();
                cur = cur - 1;
                if (cur > 0) {
                    waitList.offer(new int[]{cur, time + n});
                }
            }
        }
        return time;
    }
}
