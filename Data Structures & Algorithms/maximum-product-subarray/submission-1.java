class Solution {
    public int maxProduct(int[] nums) {
        // base case
        if (nums.length == 1) {
            return nums[0];
        }
        int curMin = 1;
        int curMax = 1;
        int rslt = nums[0];
        for (int i : nums) {
            int temp = i * curMax;
            curMax = Math.max(Math.max(curMax * i, curMin * i), i);
            curMin = Math.min(Math.min(curMin * i, temp), i);
            rslt = Math.max(rslt, curMax);
        }
        return rslt;
    }
}
