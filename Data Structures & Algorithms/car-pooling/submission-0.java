class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int curCap = 0;
        for (int[] trip : trips) {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                int[] remove = minHeap.poll();
                curCap -= remove[1];
            }
            curCap += passenger;
            if (curCap > capacity) {
                return false;
            }
            minHeap.offer(new int[]{end, passenger});
        }
        return true;
    }
}