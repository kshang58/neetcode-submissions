class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, curSum = 0;
        for (int i = 0; i < nums.length; i ++) {
            curSum += nums[i];
            int rem = curSum % k;
            if (rem < 0) rem += k;
            int prev = map.getOrDefault(rem, 0);
            result += prev;
            map.put(rem, prev + 1);
        }
        return result;
    }
}