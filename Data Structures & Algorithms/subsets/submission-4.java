class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(rslt, sol, nums, 0);
        return rslt;
    }
    private void dfs(List<List<Integer>> rslt, List<Integer> sol, int[] nums, int level) {
        if (level == nums.length) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        sol.add(nums[level]);
        dfs(rslt, sol, nums, level + 1);
        sol.remove(sol.size() - 1);
        dfs(rslt, sol, nums, level + 1);
    }
}
