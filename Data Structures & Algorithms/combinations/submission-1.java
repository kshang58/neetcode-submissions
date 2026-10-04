class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        dfs(n, k, result, sol, 1);
        return result;
    }
    private void dfs(int n, int k, List<List<Integer>> result, List<Integer> sol, int index) {
        if (sol.size() == k) {
            result.add(new ArrayList<>(sol));
            return;
        }
        for (int i = index; i <= n; i++) {
            sol.add(i);
            dfs(n, k, result, sol, i + 1);
            sol.remove(sol.size() - 1);
        }
    }
}