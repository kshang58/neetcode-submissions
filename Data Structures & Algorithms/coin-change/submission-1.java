class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] m = new int[amount + 1];
        m[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            int steps = Integer.MAX_VALUE / 2;
            for (int c : coins) {
                if (c > i) break;
                steps = Math.min(steps, m[i - c] + 1);
            }
            m[i] = steps;
        }
        return m[amount] > amount ? -1 : m[amount];
    }
}
