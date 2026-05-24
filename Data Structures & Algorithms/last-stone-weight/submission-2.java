class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            maxHeap.offer(i);
        }
        while(maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a > b) {
                maxHeap.offer(a - b);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
