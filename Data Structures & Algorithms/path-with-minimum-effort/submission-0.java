class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // fill dis with max int
        int[][] dis = new int[m][n];
        for (int[] d : dis) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[]{0, 0, 0});
        dis[0][0] = 0;

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int r = cur[0];
            int c = cur[1];
            int h = heights[r][c];
            for (int[] dir : dirs) {

                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                int nh = heights[nr][nc];
                int eff = Math.abs(h - nh);
                int newEffort = Math.max(cur[2], eff);
                if (dis[nr][nc] <= newEffort) continue;
                dis[nr][nc] = newEffort;
                minHeap.offer(new int[]{nr, nc, newEffort});
            }
        }
        return dis[m - 1][n - 1];
    }
}