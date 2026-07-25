class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (peak(nums, m)) {
                return m;
            } else if (m < nums.length - 1 && nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    private boolean peak(int[] nums, int p) {
        if (p == 0 || nums[p] > nums[p - 1]) {
            if (p == nums.length - 1 || nums[p] > nums[p + 1]) {
                return true;
            }
        }
        return false;
    }
}