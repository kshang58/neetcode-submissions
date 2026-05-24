class Solution {
    // use DFS to solve
    // we have max word.length() level
    // each level we check max four direction
    public boolean exist(char[][] board, String word) {
       char[] w = word.toCharArray();
       int r = board.length;
       int c = board[0].length;
        for(int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++){
                int[][] flag = new int[r][c];
                if (dfs(board, w, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] w, int index, int r, int c) {
        // base case
        if(index == w.length) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (board[r][c] != w[index]) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = dfs(board, w, index + 1, r + 1, c) ||
        dfs(board, w, index + 1, r - 1, c) ||
        dfs(board, w, index + 1, r, c + 1) ||
        dfs(board, w, index + 1, r, c - 1);
        board[r][c] = temp;
        return found;
    }
}
