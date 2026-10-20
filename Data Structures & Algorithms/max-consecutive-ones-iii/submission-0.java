class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, count = 0, globalMax = 0;
        for (int right = 0; right < nums.length; right ++) {
            if (nums[right] == 0) count ++;
            if (count > k) {
                while (nums[left] == 1) left ++;
                left ++;
                count --;
            }
            globalMax = Math.max(globalMax, right - left + 1);
        }
        return globalMax;
    }
}