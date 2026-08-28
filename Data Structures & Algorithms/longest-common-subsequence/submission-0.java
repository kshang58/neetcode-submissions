class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();
        int m = text1Arr.length;
        int n = text2Arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
