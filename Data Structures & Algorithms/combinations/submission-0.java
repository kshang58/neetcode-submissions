class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(n, k, 1, rslt, sol);
        return rslt;
    }
    private void dfs(int n, int k, int start, List<List<Integer>> rslt, List<Integer> sol) {
        if (sol.size() == k) {
            rslt.add(new ArrayList<>(sol));
            return;
        }
        for (int i = start; i <= n; i ++) {
            sol.add(i);
            dfs(n, k, i + 1, rslt, sol);
            sol.remove(sol.size() - 1);
        }
    }
}