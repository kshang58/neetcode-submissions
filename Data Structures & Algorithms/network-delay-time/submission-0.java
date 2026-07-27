public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.putIfAbsent(time[0], new ArrayList<>());
            edges.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0], n1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t = w1;

            if (edges.containsKey(n1)) {
                for (int[] next : edges.get(n1)) {
                    int n2 = next[0], w2 = next[1];
                    if (!visited.contains(n2)) {
                        minHeap.offer(new int[]{w1 + w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
