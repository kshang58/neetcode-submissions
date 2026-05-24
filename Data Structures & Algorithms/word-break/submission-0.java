class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] c = s.toCharArray();
        int[] m = new int[c.length + 1];
        m[0] = 1;
        Set<String> hs = new HashSet<>();
        for(String word : wordDict) {
            hs.add(word);
        }

        for (int i = 1; i <= c.length; i ++) {
            int flag = 0;
            for (int j = 0; j < i; j ++) {
                if (m[j] == 1) {
                    if (hs.contains(new String(c, j, i - j))) {
                        flag = 1;
                        break;
                    }
                }
            }
            m[i] = flag;
        }
        return m[c.length] == 1;

    }
}
