class Solution {
    int[] par;
    int[] size;
    int components;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        par = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i ++) {
            par[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return components;
    }
    private int find(int a) {
        if (par[a] == a) {
            return a;
        }
        par[a] = find(par[a]);
        return par[a];
    }
    private void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) {
            return;
        }
        if (size[parA] < size[parB]) {
            par[parA] = parB;
            size[parB] += size[parA];
        } else {
            par[parB] = parA;
            size[parA] += size[parB];
        }
        components --;
    }
}