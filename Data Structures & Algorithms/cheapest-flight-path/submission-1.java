class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f : flights) {
            map.putIfAbsent(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[]{src, 0, 0});
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (cur[0] == dst) return cur[1];
            int numStops = cur[2];
            if (numStops > k) continue;
            if (cur[1] > dist[cur[0]][numStops]) continue;
            List<int[]> neis = map.get(cur[0]);
            if (neis == null || neis.size() == 0) continue;
            for (int[] nei : neis) {
                int price = nei[1] + cur[1];
                if (dist[nei[0]][numStops + 1] <= price) continue;
                minHeap.offer(new int[]{nei[0], price, numStops + 1});
                dist[nei[0]][numStops + 1] = price;
            }
        }
        return -1;
    }
}
