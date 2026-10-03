class Solution {
    public boolean check(int[] nums) {
        boolean isValley = false;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] < nums[i - 1] && !isValley) {
                isValley = true;
            } else if (nums[i] < nums[i - 1] && isValley) {
                return false;
            }
        }
        if (isValley && nums[nums.length - 1] > nums[0]) {
            return false;
        }
        return true;
    }
}