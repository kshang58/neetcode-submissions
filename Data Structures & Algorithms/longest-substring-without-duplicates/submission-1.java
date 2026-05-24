class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Set<Character> hs = new HashSet<>();
        int globalMax = 0;
        int currentLeft = 0;
        for(int i = 0; i < cs.length; i ++) {
            if(hs.contains(cs[i])) {
                for(int j = currentLeft; j < i; j ++) {
                    if (cs[j] != cs[i]) {
                        hs.remove(cs[j]);
                    } else {
                        currentLeft = j + 1;
                        break;
                    }
                }
            } else {
                hs.add(cs[i]);
                globalMax = Math.max(globalMax, i - currentLeft + 1);
            }
        }
        return globalMax;
    }
}
