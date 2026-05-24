class Solution {
    public int findMin(int[] nums) {
        // 5 6 1 2 3 4
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] < nums[r] ? nums[l] : nums[r];
    }
}
