class Solution {
    int[] parent;
    int[] size;
    int components;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            int[] edge = edges[i];
            if (!union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return null;
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }
}