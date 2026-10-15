class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.size() > 2) {
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> e = it.next();
                    e.setValue(e.getValue() - 1);
                    if (e.getValue() == 0) it.remove();
                }
            }
        }
        for (int key : map.keySet()) {
            int freq = 0;
            for (int i : nums) {
                if (i == key) freq ++;
            }
            if (freq > nums.length / 3) result.add(key);
        }
        return result;
    }
}