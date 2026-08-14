class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> hm = new HashMap<>();
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();
        for (Character c : tc) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int remaining = tc.length;
        int left = 0;
        int rsltLeft = 0;
        int rsltRight = Integer.MAX_VALUE;
        for (int right = 0; right < sc.length; right ++) {
            if (!hm.containsKey(sc[right])) {
                continue;
            }
            int rightCount = hm.get(sc[right]);
            if (rightCount > 0) {
                remaining --;
            }
            hm.put(sc[right], rightCount - 1);
            while (remaining == 0) {
                if (!hm.containsKey(sc[left])) {
                    left ++;
                    continue;
                }
                if (rsltRight - rsltLeft > right - left) {
                    rsltRight = right;
                    rsltLeft = left;
                }
                int curLeft = hm.get(sc[left]);
                if (curLeft == 0) {
                    remaining ++;
                }
                hm.put(sc[left], curLeft + 1);
                left ++;
            }
        }
        if (rsltRight == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(rsltLeft, rsltRight + 1);
    }
}
