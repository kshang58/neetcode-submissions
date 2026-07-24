class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int rslt = 0;
        for (int i : nums) {
            sum += i;
            if (hm.containsKey(sum - k)) {
                rslt += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return rslt;
    }
}