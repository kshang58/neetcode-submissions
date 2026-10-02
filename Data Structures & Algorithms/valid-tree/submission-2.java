class Solution {
    List<List<Integer>> neighbors;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        neighbors = new ArrayList<>();
        visited = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        visited.add(0);
        return dfs(0, -1) && visited.size() == n;
    }
    private boolean dfs(int n, int par) {
        List<Integer> neighbor = neighbors.get(n);
        boolean result = true;
        for (int i : neighbor) {
            if (i == par) {
                continue;
            }
            if (visited.contains(i)) return false;
            visited.add(i);
            if (dfs(i, n) == false) result = false;
        }
        return result;
    }
}
