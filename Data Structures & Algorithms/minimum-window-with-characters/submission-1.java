class Solution {
    public String minWindow(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : tc) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int remaining = tc.length;
        int left = 0;
        int ansLeft = 0;
        int ansRight = Integer.MAX_VALUE;
        for (int right = 0;  right < sc.length; right ++) {
            if (!hm.containsKey(sc[right])) {
                continue;
            }
            int curR = hm.get(sc[right]);
            if (curR > 0) {
                remaining --;
            }
            hm.put(sc[right], curR - 1);
            while (remaining == 0) {
                if ((right - left) < (ansRight - ansLeft)) {
                    ansRight = right;
                    ansLeft = left;
                }
                if (!hm.containsKey(sc[left])) {
                    left ++;
                    continue;
                }
                int curL = hm.get(sc[left]);
                if (curL == 0) {
                    remaining ++;
                }
                hm.put(sc[left], curL + 1);
                left ++;
            }
        }
        if (ansRight == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(ansLeft, ansRight + 1);
    }
}
