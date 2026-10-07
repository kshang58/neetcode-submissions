class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int target = sum / k;
        if (nums[nums.length - 1] > target) return false;
        int[] used = new int[nums.length];
        return dfs(nums, used, k, target, target, nums.length - 1);
    }
    private boolean dfs(int[] nums, int[] used, int k, int target, int remaining, int index) {
        if (k == 1) {
            return true;
        }
        if (remaining == 0) return dfs(nums, used, k - 1, target, target, nums.length - 1);
        if (index < 0) return false;
        if (used[index] == 1 || nums[index] > remaining) return dfs(nums, used, k, target, remaining, index - 1);

        used[index] = 1;
        if (dfs(nums, used, k, target, remaining - nums[index], index - 1)) return true;
        used[index] = 0;
        while (index > 0 && nums[index - 1] == nums[index]) {
            index = index - 1;
        }
        if (dfs(nums, used, k, target, remaining, index - 1)) return true;
        return false;
    }
}