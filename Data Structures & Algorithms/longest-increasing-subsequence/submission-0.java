class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] m = new int[nums.length];
        m[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i ++) {
            int max = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(m[j] + 1, max);
                }
            }
            m[i] = max;
            globalMax = Math.max(globalMax, m[i]);
        }
        return globalMax;
    }
}
