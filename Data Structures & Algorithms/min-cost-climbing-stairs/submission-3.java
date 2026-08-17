class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0;
        int prev1 = 0;
        int cur = 0;
        for (int i = 2; i < cost.length + 1; i ++) {
            cur = Math.min(prev2 + cost[i - 2], prev1 + cost[i - 1]);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
