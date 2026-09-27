class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long tar = (long) target - nums[i] - nums[j];
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k ++;
                        continue;
                    }
                    long sum = (long) nums[k] + nums[l];
                    if (sum == tar) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        sol.add(nums[l]);
                        result.add(sol);
                        k ++;
                        l --;
                    } else if (sum < tar){
                        k ++;
                    } else {
                        l --;
                    }
                }
            }
        }
        return result;
    }
}