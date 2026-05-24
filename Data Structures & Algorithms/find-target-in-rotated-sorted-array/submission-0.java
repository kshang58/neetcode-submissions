class Solution {
    public int search(int[] nums, int target) {
        // if mid == target return mid
        // if mid < right 
        //      if target < right && target > mid -> left = mid + 1
        //      else right = mid - 1
        // if mid > right
        //      if target < mid && target > left -> right = mid - 1
        //      else left = mid + 1
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
