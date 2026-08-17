class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> pos = new HashSet<>();
    Set<Integer> neg = new HashSet<>();
    int result;
    public int totalNQueens(int n) {
        result = 0;
        dfs(0, n);
        return result;
    }
    private void dfs(int index, int n) {
        if (index == n) {
            result ++;
            return;
        }
        for (int c = 0; c < n; c ++) {
            if (col.contains(c) || pos.contains(c + index) || neg.contains(index - c)) {
                continue;
            }
            col.add(c);
            pos.add(c + index);
            neg.add(index - c);
            dfs(index + 1, n);
            col.remove(c);
            pos.remove(c + index);
            neg.remove(index - c);
        }
    }
}