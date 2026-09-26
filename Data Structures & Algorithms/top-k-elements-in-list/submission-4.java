class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
                continue;
            }
            if (minHeap.peek().getValue() < e.getValue()) {
                minHeap.poll();
                minHeap.offer(e);
            }
        }
        int[] result = new int[Math.min(k, minHeap.size())];
        for (int i = 0; i < result.length; i ++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}