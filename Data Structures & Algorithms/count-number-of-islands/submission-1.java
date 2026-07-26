class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    sum ++;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        grid[cur[0]][cur[1]] = '#';
                        if (cur[0] > 0 && grid[cur[0] - 1][cur[1]] == '1') {
                            queue.offer(new int[]{cur[0] - 1, cur[1]});
                        }
                        if (cur[0] < grid.length - 1 && grid[cur[0] + 1][cur[1]] == '1') {
                            queue.offer(new int[]{cur[0] + 1, cur[1]});
                        }
                        if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] == '1') {
                            queue.offer(new int[]{cur[0], cur[1] - 1});
                        }
                        if (cur[1] < grid[0].length - 1 && grid[cur[0]][cur[1] + 1] == '1') {
                            queue.offer(new int[]{cur[0], cur[1] + 1});
                        }
                    }
                }
            }
        }
        return sum;
    }
}
