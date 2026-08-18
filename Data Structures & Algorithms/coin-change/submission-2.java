class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }
        Arrays.sort(coins);
        int[] m = new int[amount + 1];
        m[0] = 0;
        for (int i = 1; i <= amount ; i ++) {
            int steps = 20000;
            for (int c : coins) {
                if (i < c) {
                    break;
                } else {
                    steps = Math.min(steps, m[i - c] + 1);
                }
            }
            m[i] = steps;
        }
        return m[amount] > amount ? -1 : m[amount];
    }
}
