class Solution {
    // Use DFS to resolve
    // How many level: nums.length 
    // Number of node each level = how many nums[index] we use in this level
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        DFS(nums, target, 0, rslt, sol);
        return rslt;
    }

    private void DFS(int[] nums, int target, int index, List<List<Integer>> rslt, List<Integer> sol) {
        // base case
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            sol.add(nums[i]);
            DFS(nums, target - nums[i], i, rslt, sol);
            sol.remove(sol.size() - 1);
        }
    }
}
