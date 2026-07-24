class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i, j) -> (i - j));
        for (int i = 0; i < nums.length; i ++) {
            if (minHeap.size() >= k) {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            } else {
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
