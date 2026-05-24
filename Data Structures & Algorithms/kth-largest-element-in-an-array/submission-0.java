class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i ++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.offer(nums[i]);
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();
    }
}
