class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] map = new int[l][2];
        for (int i = 0; i < l; i ++) {
            for (char c : strs[i].toCharArray()) {
                map[i][c - '0'] ++;
            }
        }
        int[][][] dp = new int[l + 1][m + 1][n + 1];
        for (int i = 1; i <= l; i ++) {
            for (int j = 0; j <= m; j ++) {
                for (int k = 0; k <= n; k ++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= map[i - 1][0] && k >= map[i - 1][1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - map[i - 1][0]][k - map[i - 1][1]]);
                    }
                }
            }
        }
        return dp[l][m][n];
    }
}