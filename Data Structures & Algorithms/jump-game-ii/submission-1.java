class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] m = new int[n];
        m[n - 1] = 0;
        for (int i = n - 2; i >= 0; i --) {
            int cur = 2000;
            for (int j = i + 1; j <= i + nums[i]; j ++) {
                if (j >= n) {
                    break;
                }
                cur = Math.min(m[j] + 1, cur);
            }
            m[i] = cur;
        }
        return m[0];
    }
}
