class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i ++) {
            newNums[i + 1] = nums[i];
        }
        dp = new int[n + 2][n + 2];
        return dfs(newNums, 1, n);
    }
    private int dfs(int[] nums, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        if (l == r) {
            return nums[l - 1] * nums[l] * nums[l + 1];
        }
        int max = 0;
        for (int i = l; i <= r; i ++) {
            int cur = dfs(nums, l, i - 1) + nums[l - 1] * nums[i] * nums[r + 1] + dfs(nums, i + 1, r);
            max = Math.max(max, cur);
        }
        dp[l][r] = max;
        return max;
    }
}
