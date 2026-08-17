class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] m = new int[cost.length + 1];
        m[0] = 0;
        m[1] = 0;
        for (int i = 2; i < m.length; i ++) {
            m[i] = Math.min(m[i - 2] + cost[i - 2], m[i - 1] + cost[i - 1]);
        }
        return m[m.length - 1];
    }
}
