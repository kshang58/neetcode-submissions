class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},{0, 1}, {0, -1}};
    public void solve(char[][] board) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';

                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    queue.offer(new int[]{i, j});

                    if (bfs(board, queue, list, i, j)) {
                        for (int[] p : list) {
                            board[p[0]][p[1]] = '#';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private boolean bfs(char[][] board, Deque<int[]> queue, List<int[]> list, int startRow, int startCol) {
        boolean flag = startRow == 0 || startRow == board.length - 1 || startCol == 0 || startCol == board[0].length - 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dire : directions) {
                int nr = cur[0] + dire[0];
                int nc = cur[1] + dire[1];
                if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O') {
                    board[nr][nc] = 'X';
                    queue.offer(new int[]{nr, nc});
                    list.add(new int[]{nr, nc});
                    if (nr == 0 || nc == 0 || nr == board.length - 1 || nc == board[0].length - 1) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
