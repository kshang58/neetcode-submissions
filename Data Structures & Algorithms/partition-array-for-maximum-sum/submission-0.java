class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return dfs(arr, k, 0, dp);
    }
    private int dfs(int[] arr, int k, int index, int[] dp) {
        if (index == arr.length) return 0;
        if (dp[index] != -1) return dp[index];
        int curMax = 0;
        int curTotal = 0;
        for (int i = index; i < Math.min(index + k, arr.length); i ++) {
            if (arr[i] > curMax) {
                curMax = arr[i];
            }
            int curSum = curMax * (i - index + 1);
            int futureSum = dfs(arr, k, i + 1, dp);
            curTotal = Math.max(curSum + futureSum, curTotal);
        }
        dp[index] = curTotal;
        return curTotal;
    } 
}