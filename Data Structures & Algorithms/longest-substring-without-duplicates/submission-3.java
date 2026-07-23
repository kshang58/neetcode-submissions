class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Set<Character> hs = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < cs.length) {
            while (hs.contains(cs[right])) {
                hs.remove(cs[left]);
                left ++;
            }
            hs.add(cs[right]);
            max = Math.max(max, hs.size());
            right ++;
        }
        return max;
    }
}
