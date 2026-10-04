class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, result, 0);
        return result;
    }
    private void dfs(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            List<Integer> sol = new ArrayList<>();
            for (int i : nums) {
                sol.add(i);
            }
            result.add(sol);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i ++) {
            if (!set.add(nums[i])) continue;
            swap(nums, i, index);
            dfs(nums, result, index + 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}