class Solution {
    public boolean canJump(int[] nums) {
        boolean[] m = new boolean[nums.length];
        m[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i --) {
            for (int j = 0; j <= nums[i]; j ++) {
                if(m[i + j] == true) {
                    m[i] = true;
                    break;
                }
            }
        }
        return m[0];
    }
}
