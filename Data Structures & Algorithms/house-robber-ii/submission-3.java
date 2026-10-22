class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int num1 = robber(nums, 0, nums.length - 2);
        int num2 = robber(nums, 1, nums.length - 1);
        return Math.max(num1, num2);
    }
    private int robber(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k ++) {
            dp[k - i] = Math.max(dp[k - i - 1], nums[k] + dp[k - i - 2]);
        }
        return dp[dp.length - 1];
    }
}
