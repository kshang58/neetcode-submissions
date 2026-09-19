class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] t = new int[n + 1];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[k] = 0;
        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(time);
        } 
        minHeap.offer(new int[]{k, 0});
        while (!minHeap.isEmpty()) {
            int[] a = minHeap.poll();
            int curTar = a[0];
            int curTime = a[1];
            if (curTime > t[curTar]) continue;
            List<int[]> next = map.get(curTar);
            if (next == null) {
                continue;
            }
            for (int[] nex : next) {
                int nextTime = nex[2] + curTime;
                if (nextTime < t[nex[1]]) {
                    t[nex[1]] = nextTime;
                    minHeap.offer(new int[]{nex[1], nextTime});

                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (t[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, t[i]);
        }
        return result;
    }
}
