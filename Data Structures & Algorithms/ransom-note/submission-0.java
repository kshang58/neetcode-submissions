class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] mArray = magazine.toCharArray();
        char[] rArray = ransomNote.toCharArray();
        for (char c : mArray) {
            map[c - 'a'] ++;
        }
        for (char c : rArray) {
            map[c - 'a'] --;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}