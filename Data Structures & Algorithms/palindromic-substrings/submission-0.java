class Solution {
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int tot = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i ++) {
            int tot1 = pal(c, i, i);
            int tot2 = pal(c, i, i + 1);
            tot = tot + tot1 + tot2;
        }
        return tot;
    }
    private int pal(char[] c, int i, int j) {
        int tot = 0;
        while(i >= 0 && j < c.length && c[i] == c[j]) {
            tot ++;
            i --;
            j ++;
        }
        return tot;
    }
}
