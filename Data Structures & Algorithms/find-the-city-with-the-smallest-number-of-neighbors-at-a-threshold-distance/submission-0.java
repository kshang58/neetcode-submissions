class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build the graph
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>())
            .add(new int[]{edge[1], edge[2]});

            map.computeIfAbsent(edge[1], k -> new ArrayList<>())
            .add(new int[]{edge[0], edge[2]});
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i ++) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            Map<Integer, Integer> visited = new HashMap<>();
            minHeap.offer(new int[]{i, 0});
            visited.put(i, 0);
            while (!minHeap.isEmpty()) {
                int[] cur = minHeap.poll();
                if (visited.get(cur[0]) < cur[1]) continue;
                List<int[]> neis = map.getOrDefault(cur[0], new ArrayList<>());
                for (int[] nei : neis) {
                    if (cur[1] + nei[1] > distanceThreshold) continue;
                    if (visited.containsKey(nei[0]) && visited.get(nei[0]) <= cur[1] + nei[1]) continue;
                    visited.put(nei[0], cur[1] + nei[1]);
                    minHeap.offer(new int[]{nei[0], cur[1] + nei[1]});
                }
            }
            result[i] = visited.size() - 1;
        }
        int globalMin = n, res = 0;
        for (int i = 0; i < n; i ++) {
            if (result[i] <= globalMin) {
                globalMin = result[i];
                res = i;
            }
        }
        return res;

    }
}