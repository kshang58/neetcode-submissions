class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                int pivot = i - 1;
                for (int j = nums.length - 1; j > pivot; j --) {
                    if (nums[j] > nums[pivot]) {
                        swap(nums, j, pivot);
                        reverse(nums, pivot + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        int i = 0, j = nums.length - 1;
        reverse(nums, i, j);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i ++;
            j --;
        }
    }
}