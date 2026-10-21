class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = target; i >= n; i --) {
                dp[i] = dp[i] || dp[i - n];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}