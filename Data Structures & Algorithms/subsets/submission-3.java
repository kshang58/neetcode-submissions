class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(nums, 0, rslt, sol);
        return rslt;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> rslt, List<Integer> sol) {
        if (index == nums.length) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        sol.add(nums[index]);
        dfs(nums, index + 1, rslt, sol);
        sol.remove(sol.size() - 1);
        dfs(nums, index + 1, rslt, sol);
    }
}
