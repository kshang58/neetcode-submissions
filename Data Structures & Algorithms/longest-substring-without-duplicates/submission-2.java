class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int globalMax = 0;
        int leftWindow = 0;
        for (int i = 0; i < array.length; i ++) {
            while (set.contains(array[i])) {
                set.remove(array[leftWindow]);
                leftWindow ++;
            }
            set.add(array[i]);
            globalMax = Math.max(globalMax, i - leftWindow + 1);
        }
        return globalMax;
    }
}
