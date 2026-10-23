class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int globalMax = 0;
        for (int i = 0; i < m; i ++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            globalMax = Math.max(globalMax, dp[i][0]);
            for (int j = 1; j < n; j ++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j] == '0' ? 0 : 1;
                    globalMax = Math.max(globalMax, dp[i][j]);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                globalMax = Math.max(globalMax, dp[i][j]);
            }
        }
        return globalMax * globalMax;
    }
}