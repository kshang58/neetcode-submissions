class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i ++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i ++) {
            int start = jobs[i][0];
            int j = findBound(jobs, start, i);

            // Skip vs take
            dp[i + 1] = Math.max(
                dp[i],
                dp[j] + jobs[i][2]
            );
        }
        return dp[n];
    }
    private int findBound(int[][] jobs, int startTime, int i) {
        int l = 0, r = i;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (jobs[m][1] > startTime) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}