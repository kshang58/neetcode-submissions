class Solution {
    public int minCapability(int[] nums, int k) {
        int globalMin = Integer.MAX_VALUE;
        int globalMax = 0;
        for (int n : nums) {
            if (n < globalMin) globalMin = n;
            if (n > globalMax) globalMax = n;
        }
        int l = globalMin, r = globalMax;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (valid(nums, k, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    private boolean valid(int[] nums, int k, int m) {
        int index = 0, count = 0;
        while (index < nums.length) {
            if (nums[index] <= m) {
                index += 2;
                count ++;
            } else {
                index ++;
            }
            if (count == k) return true;
        }
        return count == k;
    }
}
