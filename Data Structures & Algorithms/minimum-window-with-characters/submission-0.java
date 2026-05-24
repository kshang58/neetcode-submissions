class Solution {
    public String minWindow(String s, String t) {
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        // pre-processing
        for (char c : tc) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int match = 0;
        int rslt = Integer.MAX_VALUE;
        int globalLeft = 0;
        for (int i = 0; i < sc.length; i ++) {
            if (!hm.containsKey(sc[i])) {
                continue;
            } else {
                int num = hm.get(sc[i]);
                hm.put(sc[i], num - 1);
                if (num - 1 == 0) {
                    match ++;
                }
                if (match == hm.size()) {
                    while (!hm.containsKey(sc[left]) || hm.get(sc[left]) + 1 <= 0) {
                        if (hm.containsKey(sc[left])) {
                            hm.put(sc[left], hm.get(sc[left]) + 1);
                        }
                        left ++;
                    }
                    if (i - left + 1 < rslt) {
                        globalLeft = left;
                        rslt = i - left + 1;
                    }
                }
            }
        }
        return rslt == Integer.MAX_VALUE ? "" : s.substring(globalLeft, globalLeft + rslt);
    }
}
