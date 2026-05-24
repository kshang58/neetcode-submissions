class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hm = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (char c : sc) {
            hm[c - 'a'] ++;
        }
        for (char c : tc) {
            hm[c - 'a'] --;
            if (hm[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
