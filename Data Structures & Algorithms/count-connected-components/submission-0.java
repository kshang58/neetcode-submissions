class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i ++) {
            if (visited.contains(i)) continue;
            count ++;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            visited.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                List<Integer> neis = graph.get(cur);
                for (int nei : neis) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }
        }
        return count;
    }
}
