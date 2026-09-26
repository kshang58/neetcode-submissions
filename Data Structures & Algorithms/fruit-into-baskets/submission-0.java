class Solution {
    public int totalFruit(int[] fruits) {
        // find the longest subarray that contains at most 2 int type
        int l = 0;
        int globalMax = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < fruits.length; r ++) {
            if (map.containsKey(fruits[r])) {
                map.put(fruits[r], r);
                globalMax = Math.max(globalMax, r - l + 1);
                continue;
            }
            map.put(fruits[r], r);
            if (map.size() > 2) {
                int index = fruits.length;
                int key = 0;
                for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                    index = Math.min(index, e.getValue());
                    if (e.getValue() == index) key = e.getKey();
                }
                l = index + 1;
                map.remove(key);
            } else {
                globalMax = Math.max(globalMax, r - l + 1);
            }
        }
        return globalMax;
    }
}