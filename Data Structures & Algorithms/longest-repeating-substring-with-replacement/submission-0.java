class Solution {
    public int characterReplacement(String s, int k) {
        char[] sc = s.toCharArray();
        int[] hm = new int[26];
        int left = 0;
        int right = 0;
        int maxF = 0;
        int rslt = 0;
        while(right < sc.length) {
            hm[sc[right] - 'A'] ++;
            if(hm[sc[right] - 'A'] > maxF) {
                maxF ++;
            } else if (right - left + 1 - maxF > k) {
                hm[sc[left] - 'A'] --;
                left ++;
            }
            rslt = Math.max(rslt, right - left + 1);
            right ++;
        }
        return rslt;
    }
}
