class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int firstOcc = 0;
        int lastOcc = 0;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (nums[l] == target) {
            firstOcc = l;
        } else if (nums[r] == target) {
            firstOcc = r;
        } else {
            return new int[]{-1, -1};
        }
        l = firstOcc;
        r = nums.length - 1;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (nums[r] == target) {
            lastOcc = r;
        } else {
            lastOcc = l;
        }
        return new int[]{firstOcc, lastOcc};
    }
}