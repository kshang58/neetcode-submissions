class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] arr = s.toCharArray();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[arr.length + 1];
        dp[0] = true;
        for (int i = 1; i <= arr.length; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[arr.length];
    }
}
