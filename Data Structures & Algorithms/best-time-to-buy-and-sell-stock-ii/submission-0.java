class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int globalMax = 0;
        for (int p : prices) {
            if (p > bp) {
                globalMax += p - bp;
            } 
            bp = p;
        }
        return globalMax;
    }
}