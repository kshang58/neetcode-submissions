class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] - '0';
        }
        Deque<int[]> queue = new ArrayDeque<>();
        int tot = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (visited[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                }
                queue.offerFirst(new int[]{i, j});
                tot ++;
                while (!queue.isEmpty()) {
                    int[] cur = queue.pollLast();
                    visited[cur[0]][cur[1]] = 1;
                    if (cur[0] - 1 >= 0 && visited[cur[0] - 1][cur[1]] == 0 && grid[cur[0] - 1][cur[1]] == '1') {
                        queue.offerFirst(new int[]{cur[0] - 1, cur[1]});
                    }
                    if (cur[0] + 1 < grid.length && visited[cur[0] + 1][cur[1]] == 0 && grid[cur[0] + 1][cur[1]] == '1') {
                        queue.offerFirst(new int[]{cur[0] + 1, cur[1]});
                    }
                    if (cur[1] - 1 >= 0 && visited[cur[0]][cur[1] - 1] == 0 && grid[cur[0]][cur[1] - 1] == '1') {
                        queue.offerFirst(new int[]{cur[0], cur[1] - 1});
                    }
                    if (cur[1] + 1 < grid[0].length && visited[cur[0]][cur[1] + 1] == 0 && grid[cur[0]][cur[1] + 1] == '1') {
                        queue.offerFirst(new int[]{cur[0], cur[1] + 1});
                    }
                }
            }
        }
        return tot;
    }
}
