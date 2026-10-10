class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n > m) return -1;
        long nee = 0;
        long hay = 0;
        for (int i = 0; i < n; i ++) {
            nee = nee * 26 + needle.charAt(i) - 'a';
            hay = hay * 26 + haystack.charAt(i) - 'a';
        }
        if (nee == hay) return 0;
        for (int i = n; i < m; i ++) {
            hay -= (long) Math.pow(26, n - 1) * (haystack.charAt(i - n) - 'a');
            hay *= 26;
            hay += haystack.charAt(i) - 'a';
            if (hay == nee) return i - n + 1;
        }
        return -1;
    }
}