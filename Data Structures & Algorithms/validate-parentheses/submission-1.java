class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        for(char c : cs) {
            if (c == '{' || c == '(' || c == '[') {
                stack.offerFirst(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char top = stack.pollFirst();
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
