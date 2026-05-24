class Solution {
    // Use DFS to solve the subset problem
    // n : length of the int array
    // Recursion tree: we have n level, in each level, we can deside whether
    // we want to add the element or not
    // base case: when index == n
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        helper(nums, 0, rslt, sol);
        return rslt;
    }
    private void helper(int[] nums, int index, List<List<Integer>> rslt, List<Integer> sol){
        if(index == nums.length) {
            rslt.add(new ArrayList(sol));
            return;
        }
        sol.add(nums[index]);
        helper(nums, index + 1, rslt, sol);
        sol.remove(sol.size() - 1);
        helper(nums, index + 1, rslt, sol);
    }
}
