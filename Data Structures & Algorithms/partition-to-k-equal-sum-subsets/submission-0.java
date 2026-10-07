class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        int target = sum / k;
        int[] used = new int[nums.length];
        return dfs(nums, used, k, target, target, 0);
    }
    private boolean dfs(int[] nums, int[] used, int k, int target, int remaining, int index) {
        if (k == 0) {
            return true;
        }
        if (remaining == 0) return dfs(nums, used, k - 1, target, target, 0);
        if (index == nums.length) return false;
        if (used[index] == 1) return dfs(nums, used, k, target, remaining, index + 1);
        if (nums[index] > remaining) return false;
        used[index] = 1;
        if (dfs(nums, used, k, target, remaining - nums[index], index + 1)) return true;
        used[index] = 0;
        if (dfs(nums, used, k, target, remaining, index + 1)) return true;
        return false;
    }
}