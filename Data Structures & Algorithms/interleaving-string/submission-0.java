class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        } else if (s3.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int j = n - 1; j >= 0; j --) {
            dp[m][j] = dp[m][j + 1] &&  s2.charAt(j) == s3.charAt(m + j);
        }
        for (int i = m - 1; i >= 0; i --) {
            dp[i][n] = dp[i + 1][n] && s1.charAt(i) == s3.charAt(i + n);
            for (int j = n - 1; j >= 0; j --) {
                if (s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}