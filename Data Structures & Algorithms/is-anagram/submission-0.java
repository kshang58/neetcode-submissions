class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            int num = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), num + 1);
        }
        for (int i = 0; i < len; i ++) {
            int num = hm.getOrDefault(t.charAt(i), 0);
            if (num == 0) {
                return false;
            }
            hm.put(t.charAt(i), num - 1);
        }
        return true;
    }
}
