class Solution {
    private int dis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] rslt = new int[k][2];
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> dis(b) - dis(a));
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        for(int i = 0; i < k; i ++) {
            rslt[i] = maxHeap.poll();
        }
        return rslt;
    }
}
