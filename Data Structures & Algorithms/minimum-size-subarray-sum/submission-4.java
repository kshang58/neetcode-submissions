class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int globalMin = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target && l < nums.length) {
                globalMin = Math.min(globalMin, r - l + 1);
                sum -= nums[l];
                l ++;
            } 
            r ++;
        }
        return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
    }
}