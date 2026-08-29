class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // empty string matches empty pattern
        dp[0][0] = true;

        // empty string vs pattern like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // Case 1: normal character or '.'
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: '*'
                else if (pc == '*') {
                    // x* appears 0 times
                    dp[i][j] = dp[i][j - 2];

                    // x* appears 1 or more times
                    char prev = p.charAt(j - 2);

                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}