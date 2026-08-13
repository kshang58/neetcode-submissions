class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int tot = 0;
        while (i <= j) {
            if (nums[i] == val) {
                swap(nums, i, j);
                j --;
                tot ++;
            } else {
                i ++;
            }
        }
        return nums.length - tot;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}