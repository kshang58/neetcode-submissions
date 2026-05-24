class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], i);
            }
            if(hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i) {
                sol[0] = hm.get(target - nums[i]);
                sol[1] = i;
            }
        }
        return sol;
    }
}
