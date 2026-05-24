class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> lhsc = new ArrayList<>();
        List<Set<Character>> lhss = new ArrayList<>();
        for(int i = 0; i < board.length; i ++) {
            lhsc.add(new HashSet<>());
            lhss.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i ++) {
            Set<Character> hsr = new HashSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = (i / 3) * 3 + (j / 3);
                Set<Character> hsc = lhsc.get(j);
                Set<Character> hss = lhss.get(index);
                if (hsr.add(board[i][j]) && hsc.add(board[i][j]) && hss.add(board[i][j])) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
