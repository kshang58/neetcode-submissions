class Solution {
    private Map<String, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }
    private int dfs(int index, boolean buy, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }
        String key = index + "-" + buy;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int profit;
        if (buy) {
            int b = -prices[index] + dfs(index + 1, false, prices);
            int h = dfs(index + 1, true, prices);
            profit = Math.max(b, h);
        } else {
            int s = prices[index] + dfs(index + 2, true, prices);
            int h = dfs(index + 1, false, prices);
            profit = Math.max(s, h);
        }
        cache.put(key, profit);
        return profit;
    }
}
