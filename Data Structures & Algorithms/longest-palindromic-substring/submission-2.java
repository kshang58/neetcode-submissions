class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int globalMax = 0;
        int globalLeft = 0;
        for (int i = 0; i < c.length; i ++) {
            int len1 = pal(c, i, i);
            int len2 = pal(c, i, i + 1);
            int curMax = Math.max(len1, len2);
            if (curMax > globalMax) {
                globalMax = curMax;
                globalLeft = i - (curMax - 1) / 2;
            }
        }
        return new String(c, globalLeft, globalMax);
    }
    private int pal(char[] c, int l, int r) {
        while(l >= 0 && r < c.length && c[l] == c[r]) {
            l --;
            r ++;
        }
        return r - l - 1;
    }
}
