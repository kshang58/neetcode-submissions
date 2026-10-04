class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(nums, result, sol, 0);
        return result;
    }
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> sol, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(sol));
            return;
        }
        sol.add(nums[index]);
        dfs(nums, result, sol, index + 1);
        sol.remove(sol.size() - 1);
        dfs(nums, result, sol, index + 1);
    }
}