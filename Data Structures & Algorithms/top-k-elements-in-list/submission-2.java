class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (index < k) {
                minHeap.offer(e);
                index ++;
                continue;
            }
            if (e.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(e);
                index ++;
            }
        }
        int[] rslt = new int[k];
        for (int i = 0; i < k; i ++) {
            rslt[i] = minHeap.poll().getKey();
        }
        return rslt;
    }
}
