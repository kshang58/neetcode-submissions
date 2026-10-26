class Solution {
    public int pivotIndex(int[] nums) {
        int[] rightSum = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i ++) {
            rightSum[i + 1] = rightSum[i] + nums[nums.length - 1 - i];
        }
        int leftSum = 0;
        for (int i = 0; i <= nums.length - 1; i ++) {
            if (leftSum == rightSum[nums.length - 1 - i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}