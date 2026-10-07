class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        dfs(n, queens, result, 0);
        return result;
    }
    private void dfs(int n, int[] queens, List<List<String>> result, int index) {
        if (index == n) {
            List<String> sol = new ArrayList<>();
            for (int q : queens) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i ++) {
                    if (i == q) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                sol.add(sb.toString());
            }
            result.add(sol);
        }
        for (int c = 0; c < n; c ++) {
            if (isValid(queens, index, c)) {
                queens[index] = c;
                dfs(n, queens, result, index + 1);
                queens[index] = -1;
            }
        }
    }
    private boolean isValid(int[] queens, int r, int c) {
        for (int i = 0; i < queens.length; i ++) {
            if (queens[i] == -1) break;
            if (queens[i] == c) return false;
            if (Math.abs(c - queens[i]) == r - i) return false;
        }
        return true;
    }
}
