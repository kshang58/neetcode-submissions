class Solution {
    public List<String> generateParenthesis(int n) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        List<String> rslt = new ArrayList<>();
        dfs(n, stack, sb, rslt);
        return rslt;
    }
    private void dfs(int n, Deque<Character> stack, StringBuilder sb, List<String> rslt) {
        if (n == 0 && stack.isEmpty()) {
            rslt.add(new String(sb.toString()));
            return;
        }
        if (n > 0) {
            sb.append('(');
            stack.offerFirst('(');
            dfs(n - 1, stack, sb, rslt);
            sb.deleteCharAt(sb.length() - 1);
            stack.pollFirst();
        }
        if (!stack.isEmpty()) {
            sb.append(')');
            stack.pollFirst();
            dfs(n, stack, sb, rslt);
            sb.deleteCharAt(sb.length() - 1);
            stack.offerFirst('(');
        }
    }
}
