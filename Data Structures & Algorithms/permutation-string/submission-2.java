class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        if (matches(count1, count2)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {
            count2[s2.charAt(right) - 'a']++;
            count2[s2.charAt(right - s1.length()) - 'a']--;

            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
