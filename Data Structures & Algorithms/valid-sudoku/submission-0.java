class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> hmc = new ArrayList<>();
        List<Set<Character>> hms = new ArrayList<>();
        for(int i = 0; i < board.length; i ++) {
            hmc.add(new HashSet<>());
            hms.add(new HashSet<>());
        }
        for(int i = 0; i < board.length; i ++) {
            Set<Character> hsr = new HashSet<>();
            for (int j = 0; j < board.length; j ++) {
                if (board[i][j] == '.') {
                    continue;
                }
                Set<Character> hsc = hmc.get(j);
                Set<Character> hss = hms.get((i / 3) * 3 + (j / 3));
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
