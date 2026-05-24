class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            maxHeap.offer(i);
        }
        while(maxHeap.size() > 1) {
            int big1 = maxHeap.poll();
            int big2 = maxHeap.poll();
            if (big1 > big2) {
                maxHeap.offer(big1 - big2);
            }
        }
        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}
