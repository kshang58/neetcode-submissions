class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();
        Set<Character> hs = new HashSet<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i ++) {
            if (hm.containsKey(sc[i])) {
                if (hm.get(sc[i]) != tc[i]) {
                    return false;
                }
                continue;
            }
            hm.put(sc[i], tc[i]);
            if (!hs.add(tc[i])) {
                return false;
            }
        }
        return true;
    }
}