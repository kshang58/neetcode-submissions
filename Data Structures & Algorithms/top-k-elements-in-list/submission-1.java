class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else {
                if (e.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(e);
                }
            }
        }
        int[] rslt = new int[k];
        for(int i = 0; i < k; i ++) {
            rslt[i] = minHeap.poll().getKey();
        }
        return rslt;
    }
}
