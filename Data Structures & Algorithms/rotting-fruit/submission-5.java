class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh ++;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            time ++;
            for (int i = 0; i < size; i ++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                if (r > 0 && grid[r - 1][c] == 1) {
                    fresh --;
                    grid[r - 1][c] = 2;
                    queue.offer(new int[]{r - 1, c});
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                    fresh --;
                    grid[r + 1][c] = 2;
                    queue.offer(new int[]{r + 1, c});
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    fresh --;
                    grid[r][c - 1] = 2;
                    queue.offer(new int[]{r, c - 1});
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    fresh --;
                    grid[r][c + 1] = 2;
                    queue.offer(new int[]{r, c + 1});
                }
            }
        }
        if (fresh == 0) {
            return time;
        } else {
            return -1;
        }
    }
}
