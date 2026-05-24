class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rslt = new ArrayList<>();
        DFS(nums, target, 0, rslt, new ArrayList<>());
        return rslt;
    }

    private void DFS(int[] nums, int target, int index, List<List<Integer>> rslt, List<Integer> sol) {
        if (target == 0) {
            rslt.add(new ArrayList<>(sol));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) break;
            sol.add(nums[i]);
            DFS(nums, target - nums[i], i, rslt, sol);
            sol.remove(sol.size() - 1);
        }
    }
}