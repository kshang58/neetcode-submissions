class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] m = new boolean[n + 1];
        m[0] = true;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (m[j] && hs.contains(s.substring(j, i))) {
                    m[i] = true;
                    break;
                }
            }
        }
        return m[n];
    }
}
