class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : array) {
            if (c == '{' || c == '(' || c == '[') {
                stack.offerFirst(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cur = stack.pollFirst();
                if ((cur == '(' && c != ')') || (cur == '[' && c != ']') || (cur == '{' && c != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
