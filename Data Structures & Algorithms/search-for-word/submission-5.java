class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordc = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == wordc[0]) {
                    boolean sol = dfs(board, wordc, i, j, 0);
                    if (sol) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] wordc, int i, int j, int index) {
        if (index == wordc.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != wordc[index]) {
            return false;
        }
        Character temp = board[i][j];
        board[i][j] = '#';
        boolean sol = dfs(board, wordc, i - 1, j, index + 1) ||
        dfs(board, wordc, i + 1, j, index + 1) ||
        dfs(board, wordc, i, j - 1, index + 1) ||
        dfs(board, wordc, i, j + 1, index + 1);
        board[i][j] = temp;
        return sol;
    }
}
