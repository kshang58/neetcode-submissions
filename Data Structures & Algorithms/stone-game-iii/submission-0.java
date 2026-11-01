class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n];
        if (dfs(stoneValue, memo, 0, n) > 0) {
            return "Alice";
        } else if (dfs(stoneValue, memo, 0, n) < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
    private int dfs(int[] stoneValue, Integer[] memo, int index, int n) {
        if (index >= n) {
            return 0;
        }
        if (memo[index] != null) return memo[index];
        int chooseOne = stoneValue[index] - dfs(stoneValue, memo, index + 1, n);
        int chooseTwo = index + 1 < n ? stoneValue[index] + stoneValue[index + 1] - dfs(stoneValue, memo, index + 2, n) : Integer.MIN_VALUE;
        int chooseThree = index + 2 < n ? stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2] - dfs(stoneValue, memo, index + 3, n) : Integer.MIN_VALUE;
        int curMax = Math.max(chooseOne, Math.max(chooseTwo, chooseThree));
        memo[index] = curMax;
        return curMax;
    }
}