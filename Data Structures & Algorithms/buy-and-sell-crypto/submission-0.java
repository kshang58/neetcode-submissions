class Solution {
    public int maxProfit(int[] prices) {
        int globalMax = 0;
        int buyPoint = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] - prices[buyPoint] > globalMax) {
                globalMax = prices[i] - prices[buyPoint];
            } else if (prices[i] < prices[buyPoint]) {
                buyPoint = i;
            }
        }
        return globalMax;
    }
}
