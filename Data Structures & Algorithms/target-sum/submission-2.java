class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                int key = e.getKey();
                int value = e.getValue();
                next.put(key + num, next.getOrDefault(key + num, 0) + value);
                next.put(key - num, next.getOrDefault(key - num, 0) + value);
            }
            dp = next;
        }
        return dp.getOrDefault(target, 0);
    }
}
