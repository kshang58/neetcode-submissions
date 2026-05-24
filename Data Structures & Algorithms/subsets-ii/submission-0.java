class Solution {
    // First, sort the array O(nlogn)
    // use DFS, level of recursion, nums.length
    // each level, we can add or don't add
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        sub(nums, 0, rslt, sol);
        return rslt;
    }
    private void sub(int[] nums, int index, List<List<Integer>> rslt, List<Integer> sol) {
        // base case
        if (index == nums.length) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        sol.add(nums[index]);
        sub(nums, index + 1, rslt, sol);
        // if we decide not to add nums[index], we are not adding it anymore
        sol.remove(sol.size() - 1);
        while(index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index ++;
        }
        sub(nums, index + 1, rslt, sol);
    }
}
