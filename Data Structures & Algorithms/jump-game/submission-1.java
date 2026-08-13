class Solution {
    public boolean canJump(int[] nums) {
        int[] m = new int[nums.length];
        m[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i --) {
            for (int j = 1; j <= nums[i]; j ++) {
                if (m[i + j] == 1) {
                    m[i] = 1;
                    break;
                }
            }
        }
        return m[0] == 1;
    }
}
