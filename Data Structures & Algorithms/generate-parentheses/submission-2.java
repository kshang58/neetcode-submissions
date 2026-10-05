class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, result, sb, 0, 0);
        return result;
    }
    private void dfs(int n, List<String> result, StringBuilder sb, int l, int r) {
        if (l + r == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            dfs(n, result, sb, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            dfs(n, result, sb, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}