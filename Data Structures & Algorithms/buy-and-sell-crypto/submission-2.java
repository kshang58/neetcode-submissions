class Solution {
    public int maxProfit(int[] prices) {
        int globalMax = 0;
        int bp = Integer.MAX_VALUE;
        for (int p : prices) {
            if (bp > p) {
                bp = p;
            }
            globalMax = Math.max(globalMax, p - bp);
        }
        return globalMax;
    }
}
