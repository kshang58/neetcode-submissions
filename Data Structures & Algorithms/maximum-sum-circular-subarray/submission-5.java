class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] m = new int[nums.length];
        int[] n = new int[nums.length];
        m[0] = nums[0];
        n[0] = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];
        int tot = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            tot += nums[i];
            m[i] = m[i - 1] > 0 ? m[i - 1] + nums[i] : nums[i];
            globalMax = Math.max(globalMax, m[i]);
            n[i] = n[i - 1] < 0 ? nums[i] + n[i - 1] : nums[i];
            globalMin = Math.min(globalMin, n[i]);
        }
        if (globalMax < 0) {
            return globalMax;
        }
        return Math.max(globalMax, tot - globalMin);
    }
}