class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] m = new int[nums.length];
        m[0] = nums[0];
        m[1] = nums[1];
        int globalMax = Math.max(m[0], m[1]);
        for (int i = 2; i < nums.length; i ++) {
            int prevmax = Math.max(m[i - 2], i - 3 >= 0 ? m[i - 3] : 0);
            m[i] = prevmax + nums[i];
            globalMax = Math.max(globalMax, m[i]);
        }
        return globalMax;
    }
}
