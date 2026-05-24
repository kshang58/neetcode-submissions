class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            Integer m = hm.getOrDefault(i, 0);
            hm.put(i, m + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            minHeap.add(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] rslt = new int[k];
        for(int i = 0; i < k; i ++) {
            rslt[i] = minHeap.poll().getKey();
        }
        return rslt;
    }
}
