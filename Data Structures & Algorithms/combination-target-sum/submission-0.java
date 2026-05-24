class Solution {
    // Use DFS to resolve
    // How many level: nums.length 
    // Number of node each level = how many nums[index] we use in this level
    // base case
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        helper(nums, target, 0, rslt, sol);
        return rslt;
    }

    private void helper(int[] nums, int target, int index, List<List<Integer>> rslt, List<Integer> sol) {
        // base case
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        if (index == nums.length) {
            return;
        }
        helper(nums, target, index + 1, rslt, sol);
        for (int i = 1; i <= target / nums[index]; i ++) {
            sol.add(nums[index]);
            helper(nums, target - nums[index] * i, index + 1, rslt, sol);
        }
        for (int i = 1; i <= target / nums[index]; i ++) {
            sol.remove(sol.size() - 1);
        }
    }
}
