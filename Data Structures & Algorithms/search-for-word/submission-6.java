class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, arr, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] arr, int i, int j, int index) {
        if (index == arr.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;
        if (board[i][j] != arr[index]) return false;
        visited[i][j] = true;
        boolean result = false;
        for (int[] dir : dirs) {
            result = result || dfs(board, arr, i + dir[0], j + dir[1], index + 1);
        }
        visited[i][j] = false;
        return result;
    }
}