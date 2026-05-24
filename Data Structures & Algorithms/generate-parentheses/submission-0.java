class Solution {
    // use DFS to solve
    // we have total n level recursion tree
    // each level we can either add '(' or ')'
    // we can add max n left Parentheses, when add to solution, also add to stack
    // only when there is left Parentheses in stack top, we can add right Parentheses
    // n is the number of left Parentheses left
    public List<String> generateParenthesis(int n) {
        List<String> rslt = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        DFS(n, rslt, sb, stack);
        return rslt;
    }
    private void DFS(int n, List<String> rslt, StringBuilder sb, Deque<Integer> stack) {
        if (n == 0 && stack.peek() == null) {
            rslt.add(sb.toString());
            return;
        }
        if (n > 0) {
            stack.offerLast(1);
            sb.append('(');
            DFS(n - 1, rslt, sb, stack);
            sb.deleteCharAt(sb.length() - 1);
            stack.pollLast();
        }
        if (stack.peekLast() != null) {
            sb.append(')');
            stack.pollLast();
            DFS(n, rslt, sb, stack);
            stack.offerLast(1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
