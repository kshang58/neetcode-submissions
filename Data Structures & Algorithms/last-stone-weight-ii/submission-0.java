class Solution {
    public int lastStoneWeightII(int[] stones) {
        int tot = Arrays.stream(stones).sum();
        int target = (tot + 1) / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int s : stones) {
            for (int i = target; i >= s; i --) {
                dp[i] = dp[i] || dp[i - s];
            }
        }
        for (int i = target; i >= 0; i --) {
            if (dp[i]) {
                return Math.abs((tot - i) - i);
            }
        }
        return tot;
    }
}