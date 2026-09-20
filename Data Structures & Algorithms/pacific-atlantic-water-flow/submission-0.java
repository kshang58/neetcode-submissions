class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];
        List<List<Integer>> rslt = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            dfs(0, i, pac, heights);
            dfs(m - 1, i, atl, heights);
        }
        for (int i = 0; i < m; i ++) {
            dfs(i, 0, pac, heights);
            dfs(i, n - 1, atl, heights);
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (pac[i][j] == 1 && atl[i][j] == 1) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(i);
                    sol.add(j);
                    rslt.add(sol);
                }
            }
        }
        return rslt;
    }
    private void dfs(int r, int c, int[][] visited, int[][] heights) {
        visited[r][c] = 1;
        int h = heights[r][c];
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && heights[nr][nc] >= h && visited[nr][nc] == 0) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}
