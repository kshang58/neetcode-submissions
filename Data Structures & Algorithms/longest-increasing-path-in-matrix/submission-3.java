class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int globalMax = 1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                globalMax = Math.max(globalMax, dfs(matrix, cache, i, j, Integer.MIN_VALUE));
            }
        }
        return globalMax;
    }
    private int dfs(int[][] matrix, int[][] cache, int i, int j, int last) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        int cur = matrix[i][j];
        if (cur <= last) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int up = dfs(matrix, cache, i - 1, j, cur);
        int down = dfs(matrix, cache, i + 1, j, cur);
        int left = dfs(matrix, cache, i, j - 1, cur);
        int right = dfs(matrix, cache, i, j + 1, cur);
        int rslt = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
        cache[i][j] = rslt;
        return rslt;
    }
}
