class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rslt = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(n, rslt, board, 0);

        return rslt;
    }
    private void helper(int n, List<List<String>> rslt, char[][] board, int index) {
        if (index == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            rslt.add(copy);
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (valid(board, i, index)) {
                board[index][i] = 'Q';
                helper(n, rslt, board, index + 1);
                board[index][i] = '.';
            }
        }
    }
    private boolean valid(char[][] board, int c, int r) {
        for (int i = r - 1; i >= 0; i --) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i --, j --) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
