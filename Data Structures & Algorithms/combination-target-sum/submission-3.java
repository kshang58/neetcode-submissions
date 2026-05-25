class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, rslt, sol);
        return rslt;
    }
    // 3 3 3 target = 4
    // 4 4 target = 9
    //  5 target = 0
    private void dfs(int[] nums, int index, int target, List<List<Integer>> rslt, List<Integer> sol) {
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        } 
        for (int i = index; i < nums.length; i ++) {
            if (nums[i] > target) break;
            sol.add(nums[i]);
            dfs(nums, i, target - nums[i], rslt, sol);
            sol.remove(sol.size() - 1);
        }
    }
}
