class Solution {
    public int characterReplacement(String s, int k) {
        char[] array = s.toCharArray();
        int[] hm = new int[26];
        int right = 0;
        int maxFreq = 0;
        int left = 0;
        while (right < array.length) {
            hm[array[right] - 'A'] ++;
            if (hm[array[right] - 'A'] > maxFreq) {
                maxFreq ++;
            } else if (right - left + 1 - maxFreq > k) {
                hm[array[left] - 'A'] --;
                left ++;
            }
            right ++;
        }
        return Math.min(maxFreq + k, array.length);
    }
}
