class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] m = new int[amount + 1];
        m[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            int tot = Integer.MAX_VALUE;
            for(int j : coins) {
                if(i - j >= 0 && m[i - j] >= 0) {
                    tot = Math.min(tot, m[i - j] + 1);
                }
            }
            m[i] = tot != Integer.MAX_VALUE ? tot : -1;
        }
        return m[amount];
    }
}
