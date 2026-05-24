class Solution {
    public int maxSubArray(int[] nums) {
        int[] m = new int[nums.length];
        m[0] = nums[0];
        int globalMax = m[0];
        for (int i = 1; i < nums.length; i ++) {
            if (m[i - 1] < 0) {
                m[i] = nums[i];
            } else {
                m[i] = m[i - 1] + nums[i];
            }
            globalMax = Math.max(globalMax, m[i]);
        }
        return globalMax;
    }
}
