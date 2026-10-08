class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            neighbors.putIfAbsent(edge[0], new ArrayList<>());
            neighbors.putIfAbsent(edge[1], new ArrayList<>());
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
            degree[edge[0]] ++;
            degree[edge[1]] ++;
        }
        for (int i = 0; i < n; i ++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i ++) {
                int cur = queue.poll();
                List<Integer> neighbor = neighbors.get(cur);
                for (int nei : neighbor) {
                    degree[nei] --;
                    if (degree[nei] == 1) {
                        queue.offer(nei);
                    }
                }
                neighbors.remove(cur);
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    } 
}