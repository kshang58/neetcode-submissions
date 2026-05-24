class KthLargest {
    // 1, 2, 3, 3, 3, 5, 6, 7, 8
    // Need a minHeap of size k
    public PriorityQueue<Integer> minHeap;
    public int size;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        minHeap = new PriorityQueue<>(k);
        for(int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > size) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
