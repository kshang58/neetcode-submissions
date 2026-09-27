class Solution {
    Integer[][] dp;
    int[] suffix;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i --) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        dp = new Integer[n][n + 1];
        return dfs(0, 1);
    }
    private int dfs(int i, int M) {
        if (i >= suffix.length) return 0;
        if (i + 2 * M >= suffix.length) return suffix[i];
        if (dp[i][M] != null) return dp[i][M];
        int best = 0;
        for (int X = 1; X <= 2 * M; X ++) {
            int oppo = dfs(i + X, Math.max(M, X));
            int cur = suffix[i] - oppo;
            best = Math.max(best, cur);
        }
        dp[i][M] = best;
        return best;
    }
}