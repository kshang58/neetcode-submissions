class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1, a2) -> (a2[0] * a2[0] + a2[1] * a2[1]) - (a1[0] * a1[0] + a1[1] * a1[1]));
        int[][] rslt = new int[k][2];
        for (int i = 0; i < points.length; i ++) {
            maxHeap.offer(points[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        for (int i = 0; i < k; i ++) {
            rslt[i] = maxHeap.poll();
        }
        return rslt;
    }
}
