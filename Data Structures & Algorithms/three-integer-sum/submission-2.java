class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j ++;
                    continue;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(nums[k]);
                    j ++;
                    k --;
                    rslt.add(sol);
                } else if (nums[j] + nums[k] < target){
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return rslt;
    }
}
