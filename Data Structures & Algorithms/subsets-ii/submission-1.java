class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, rslt, new ArrayList<>());
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
        while(index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index ++;
        }
        dfs(nums, index + 1, rslt, sol);
    }
}
