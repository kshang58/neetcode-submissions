class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(nums, 0, rslt, sol, target);
        return rslt;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> rslt, List<Integer> sol, int target) {
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            if (nums[i] > target) {
                continue;
            }
            sol.add(nums[i]);
            dfs(nums, i, rslt, sol, target - nums[i]);
            sol.remove(sol.size() - 1);
        }
    }
}
