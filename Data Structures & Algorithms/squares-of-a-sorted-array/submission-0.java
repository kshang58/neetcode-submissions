class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i --) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                result[i] = nums[l] * nums[l];
                l ++;
            } else {
                result[i] = nums[r] * nums[r];
                r --;
            }
        }
        return result;
    }
}