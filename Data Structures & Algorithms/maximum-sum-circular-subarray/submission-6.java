class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int lastMin = nums[0];
        int lastMax = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i < nums.length; i ++) {
            lastMax = lastMax > 0 ? lastMax + nums[i] : nums[i];
            lastMin = lastMin > 0 ? nums[i] : lastMin + nums[i];
            globalMax = Math.max(globalMax, lastMax);
            globalMin = Math.min(globalMin, lastMin);
        }
        if (globalMax < 0) return globalMax;
        return Math.max(sum - globalMin, globalMax);
    }
}