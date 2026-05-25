class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        dfs(nums, 0, rslt);
        return rslt;
    }
    // 1 2 3
    // 123 213 321
    // 123 132 213 231 321 312
    private void dfs(int[] nums, int index, List<List<Integer>> rslt) {
        if (index == nums.length) {
            List<Integer> sol = new ArrayList<>(nums.length);
            for(int i : nums) {
                sol.add(i);
            }
            rslt.add(sol);
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            swap(nums, i, index);
            dfs(nums, index + 1, rslt);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
