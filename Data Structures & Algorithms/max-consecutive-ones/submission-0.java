class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curMax = 0;
        int globalMax = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                curMax ++;
                globalMax = Math.max(globalMax, curMax);
            } else {
                curMax = 0;
            }
        }
        return globalMax;
    }
}