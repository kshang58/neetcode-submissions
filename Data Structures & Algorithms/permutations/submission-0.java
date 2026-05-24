class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        DFS(nums, 0, rslt);
        return rslt;
    }
    private void DFS(int[] nums, int index, List<List<Integer>> rslt) {
        if (index == nums.length) {
            List<Integer> sol = new ArrayList<>(nums.length);
            for(int i : nums) {
                sol.add(i);
            }
            rslt.add(sol);
            return;
        }
        for(int i = index; i < nums.length; i ++) {
            swap(nums, index, i);
            DFS(nums, index + 1, rslt);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
