class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i ++) {
            if (i < k) {
                minHeap.offer(nums[i]);
                continue;
            }
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
