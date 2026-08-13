class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int rslt = 0;
        while (r < nums.length - 1) {
            int f = 0;
            for (int i = l; i <= r; i ++) {
                f = Math.max(f, i + nums[i]);
            }
            l = r + 1;
            r = f;
            rslt ++;
        }
        return rslt;
    }
}
