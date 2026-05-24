class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] m = new int[nums.length];
        m[0] = nums[0];
        m[1] = Math.max(nums[1], m[0]);
        for (int i = 2; i < nums.length; i ++) {
            m[i] = Math.max(m[i - 2] + nums[i], m[i - 1]);
        }
        return m[nums.length - 1];
    }
}
