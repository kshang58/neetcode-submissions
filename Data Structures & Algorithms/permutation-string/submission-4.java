class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] hm = new int[26];
        for (Character c : s1.toCharArray()) {
            hm[c - 'a'] ++;
        }
        char[] s2c = s2.toCharArray();
        int matches = s1.length();
        int left = 0;
        for (int right = 0; right < s2c.length; right ++) {
            int rightIndex = s2c[right] - 'a';
            if (hm[rightIndex] > 0) {
                matches --;
            }
            hm[rightIndex] --;
            if (right - left + 1 > s1.length()) {
                int leftIndex = s2c[left] - 'a';
                hm[leftIndex] ++;
                if (hm[leftIndex] > 0) {
                    matches ++;
                }
                left ++;
            }
            if (matches == 0) {
                return true;
            }
        }
        return false;
    }
}
