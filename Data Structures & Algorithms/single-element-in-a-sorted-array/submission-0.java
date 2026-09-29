class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 0) {
                if (m < nums.length - 1 && nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    r = m;
                }
            } else {
                if (nums[m] == nums[m + 1]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return nums[l];
    }
}