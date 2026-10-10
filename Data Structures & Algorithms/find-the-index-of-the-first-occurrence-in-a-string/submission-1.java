class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n > m) return -1;
        long BASE = 26;
        long MOD = 1_000_000_007L;
        long nee = 0;
        long hay = 0;
        long power = 1;

        for (int i = 1; i < n; i++) {
            power = power * BASE % MOD;
        }
        for (int i = 0; i < n; i ++) {
            nee = (nee * BASE + needle.charAt(i) - 'a') % MOD;
            hay = (hay * BASE + haystack.charAt(i) - 'a') % MOD;
        }
        if (nee == hay) return 0;
        for (int i = n; i < m; i ++) {
            hay -= (power * (haystack.charAt(i - n) - 'a')) % MOD;
            hay = (hay + MOD) % MOD;
            hay = (hay * BASE + haystack.charAt(i) - 'a') % MOD;
            if (hay == nee) return i - n + 1;
        }
        return -1;
    }
}