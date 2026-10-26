class Solution {
    int[] parent;
    int[] size;
    int components;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        size = new int[isConnected.length];
        components = isConnected.length;
        for (int i = 0; i < isConnected.length; i ++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < isConnected.length; i ++) {
            for (int j = 0; j < isConnected[0].length; j ++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return components;
    }
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int a, int b) {
        int parA = find(a), parB = find(b);
        if (parA == parB) return;
        if (size[parA] > size[parB]) {
            parent[parB] = parA;
            size[parA] += size[parB];
        } else {
            parent[parA] = parB;
            size[parB] += size[parA];
        }
        components --;
    }
}