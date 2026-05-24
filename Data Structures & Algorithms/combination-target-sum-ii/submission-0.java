class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort the array O(nlogn)
        Arrays.sort(candidates);
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        DFS(candidates, target, 0, rslt, sol);
        return rslt;
    }
    private void DFS(int[] nums, int target, int index, List<List<Integer>> rslt, List<Integer> sol) {
        // base case
        if(target < 0) {
            return;
        }
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            sol.add(nums[i]);
            DFS(nums, target - nums[i], i + 1, rslt, sol);
            sol.remove(sol.size() - 1);
        }
    }
}
