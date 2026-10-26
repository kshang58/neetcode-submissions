class Solution {
    // 5 1 1 5 0
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;
            nums[i] = nums[i] % k;
            if (nums[i] == 0 && i > 0) return true;
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int index = map.get(nums[i]);
                if (i - index > 1) return true;
            }
        }
        return false;
    }
}