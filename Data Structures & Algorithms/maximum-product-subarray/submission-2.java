class Solution {
    public int maxProduct(int[] nums) {
        int curMin = 1;
        int curMax = 1;
        int globalMax = nums[0];
        for (int i : nums) {
            int temp = curMax;
            curMax = Math.max(Math.max(curMin * i, curMax * i), i);
            curMin = Math.min(Math.min(curMin * i, temp * i), i);
            globalMax = Math.max(curMax, globalMax);
        }
        return globalMax;
    }
}