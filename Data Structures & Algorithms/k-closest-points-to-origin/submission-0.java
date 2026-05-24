class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < points.length; i ++) {
            int[] p = points[i];
            int dis = p[0] * p[0] + p[1] * p[1];
            if (i < k) {
                maxHeap.offer(new int[]{dis, p[0], p[1]});
            } else {
                int[] cur = maxHeap.peek();
                if (dis < cur[0]) {
                    maxHeap.poll();
                    maxHeap.offer(new int[]{dis, p[0], p[1]});
                }
            }
        }
        int[][] rslt = new int[k][2];
        for (int i = 0; i < k; i ++) {
            int[] point = maxHeap.poll();
            rslt[i] = new int[]{point[1], point[2]};
        }
        return rslt;
    }
}
