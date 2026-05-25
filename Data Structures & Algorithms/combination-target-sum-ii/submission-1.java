class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rslt = new ArrayList<>();
        dfs(candidates, target, 0, rslt, new ArrayList<>());
        return rslt;
        // 1 2 2 4 5 6 9
        //.     1.   
        //.    
    }
    private void dfs(int[] nums, int target, int index, List<List<Integer>> rslt, List<Integer> sol) {
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        if (index == nums.length || target < 0) {
            return;
        }
        sol.add(nums[index]);
        dfs(nums, target - nums[index], index + 1, rslt, sol);
        sol.remove(sol.size() - 1);
        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index ++;
        }
        dfs(nums, target, index + 1, rslt, sol);
    }
}
