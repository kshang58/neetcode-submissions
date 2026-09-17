class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 0) {
                    queue.offerFirst(new int[]{i, j});
                }
            }
        }
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cur = queue.pollLast();
                for (int[] dir : directions) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = steps;
                        queue.offerFirst(new int[]{nr, nc});
                    }
                }
                size --;
            }
            steps ++;
        }
    }
}
