class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int l = 0, rslt = 0;
        for (int r = 0; r < nums.length; r ++) {
            int cur = nums[r];
            while(!minQ.isEmpty() && minQ.peekLast() > cur) {
                minQ.pollLast();
            }
            while(!maxQ.isEmpty() && maxQ.peekLast() < cur) {
                maxQ.pollLast();
            }
            minQ.offerLast(cur);
            maxQ.offerLast(cur);
            while(maxQ.peekFirst() - minQ.peekFirst() > limit) {
                int pop = nums[l];
                l ++;
                if (maxQ.peekFirst() == pop) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == pop) {
                    minQ.pollFirst();
                }
            }
            rslt = Math.max(rslt, r - l + 1);
        }
        return rslt;
    }
}