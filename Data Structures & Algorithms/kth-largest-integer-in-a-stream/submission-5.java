class KthLargest {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int cap;
    public KthLargest(int k, int[] nums) {
        cap = k;
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > cap) {
            minHeap.poll();
        }
        return minHeap.size() == cap ? minHeap.peek() : null;
    }
}
