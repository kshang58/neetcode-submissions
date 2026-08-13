class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        char[] pc = pattern.toCharArray();
        int index = 0;
        for (char c : pc) {
            if (index == s.length()) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            while (index < s.length()) {
                if (s.charAt(index) == ' ') {
                    index ++;
                    break;
                } else {
                    sb.append(s.charAt(index));
                    index ++;
                }
            }
            String s1 = sb.toString();
            if (hm.containsKey(c)) {
                if (!s1.equals(hm.get(c))) {
                    return false;
                }
                continue;
            }
            hm.put(c, s1);
            if (!hs.add(s1)) {
                return false;
            }
        }
        return index == s.length();
    }
}