class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rslt = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if (nums[j] + nums[k] == target) {
                    if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                        j ++;
                        k --;
                        continue;
                    }
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[j]);
                    sol.add(nums[k]);
                    rslt.add(sol);
                    j ++;
                    k --;
                } else if (nums[j] + nums[k] < target) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return rslt;
    }
}
