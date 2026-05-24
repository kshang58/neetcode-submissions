class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int i : nums) {
            hs.add(i);
        }
        int globalMax = 0;
        for (int i : hs) {
            if (!hs.contains(i - 1)) {
                int length = 1;
                while(hs.contains(i + length)) {
                    length ++;
                }
                globalMax = Math.max(globalMax, length);
            }
        }
        return globalMax;
    }
}
