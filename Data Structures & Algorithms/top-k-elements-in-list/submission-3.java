class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] rslt = new int[k];
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (e1, e2) -> e1.getValue() - e2.getValue()
        );
        int index = 0;
        for (Map.Entry e : hm.entrySet()) {
            if (index < k) {
                minHeap.offer(e);
                index ++;
                continue;
            }
            minHeap.offer(e);
            minHeap.poll();
        }
        for (int i = 0; i < k; i ++) {
            rslt[i] = minHeap.poll().getKey();
        }
        return rslt;
    }
}
