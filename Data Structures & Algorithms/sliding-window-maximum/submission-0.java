class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // maintain a monotonic decresing deque
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i ++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        int[] rslt = new int[nums.length - k + 1];
        rslt[0] = deque.peekFirst();
        int index = 0;
        for (int i = k; i < nums.length; i ++) {
            if (deque.peekFirst() == nums[index]) {
                deque.pollFirst();
            }
            index ++;
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            rslt[index] = deque.peekFirst();
        }
        return rslt;
    }
}
