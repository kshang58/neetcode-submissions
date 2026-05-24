class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int r = grid.length;
        int c = grid[0].length;
        int globalMax = 0;
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    int area = 1;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        for (int[] dir : directions) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];
                            if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                                queue.offer(new int[]{nr, nc});
                                grid[nr][nc] = 0;
                                area ++;
                            }
                        }
                    }
                    globalMax = Math.max(globalMax, area);
                }
            }
        }
        return globalMax;
    }
}
