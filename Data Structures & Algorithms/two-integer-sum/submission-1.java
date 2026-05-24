class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int n = target - nums[i];
            if (hm.containsKey(n)) {
                rslt[0] = hm.get(n);
                rslt[1] = i;
                return rslt;
            }
            hm.put(nums[i], i);
        }
        return rslt;
    }
}
