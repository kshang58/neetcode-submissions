class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) {
                i ++;
                j ++;
            } else {
                j ++;
            }
        }
        return i == sc.length;
    }
}