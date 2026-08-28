class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < envelopes.length; i ++) {
            int curMax = 1;
            for (int j = 0; j < i; j ++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    curMax = Math.max(curMax, dp[j] + 1);
                }
            }
            dp[i] = curMax;
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}