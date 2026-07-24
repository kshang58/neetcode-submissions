class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (hm.containsKey(target - nums[i])) {
                rslt[0] = hm.get(target - nums[i]);
                rslt[1] = i;
                return rslt;
            }
            hm.put(nums[i], i);
        }
        return rslt;
    }
}
