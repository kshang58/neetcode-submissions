class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i --) {
            for (int j = i + 1; j <= Math.min(nums[i] + i, nums.length - 1); j ++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
}