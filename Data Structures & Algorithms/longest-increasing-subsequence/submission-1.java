class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] m = new int[nums.length];
        m[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i ++) {
            m[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    m[i] = Math.max(m[i], m[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, m[i]);
        }
        return globalMax;
    }
}
