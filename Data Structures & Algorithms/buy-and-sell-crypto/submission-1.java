class Solution {
    public int maxProfit(int[] prices) {
        int globalMax = 0;
        int buyIndex = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] - prices[buyIndex] > globalMax) {
                globalMax = prices[i] - prices[buyIndex];
            } else if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }
        }
        return globalMax;
    }
}
