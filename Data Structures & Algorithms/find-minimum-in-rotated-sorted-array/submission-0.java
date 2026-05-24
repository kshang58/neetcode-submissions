class Solution {
    // 5 6 1 2 3 4
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
