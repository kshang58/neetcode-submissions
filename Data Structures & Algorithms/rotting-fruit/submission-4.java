class Solution {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh ++;
                }
            }
        }
        int min = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k ++) {
                int[] cur = queue.poll();

                if(cur[0] - 1 >= 0 && grid[cur[0] - 1][cur[1]] == 1) {
                    queue.offer(new int[]{cur[0] - 1, cur[1]});
                    grid[cur[0] - 1][cur[1]] = 2;
                    fresh--;
                }
                if(cur[0] + 1 < grid.length && grid[cur[0] + 1][cur[1]] == 1) {
                    queue.offer(new int[]{cur[0] + 1, cur[1]});
                    grid[cur[0] + 1][cur[1]] = 2;
                    fresh--;
                }
                if(cur[1] - 1 >= 0 && grid[cur[0]][cur[1] - 1] == 1) {
                    queue.offer(new int[]{cur[0], cur[1] - 1});
                    grid[cur[0]][cur[1] - 1] = 2;
                    fresh--;
                }
                if(cur[1] + 1 < grid[0].length && grid[cur[0]][cur[1] + 1] == 1) {
                    queue.offer(new int[]{cur[0], cur[1] + 1});
                    grid[cur[0]][cur[1] + 1] = 2;
                    fresh--;
                }
            }
            min ++;
        }
        return fresh > 0 ? -1 : min;
    }
}
