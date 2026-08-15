class Solution {
    public String simplifyPath(String path) {
        String[] pathC = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : pathC) {
            if (s.equals("..")) {
                if (!deque.isEmpty()) deque.pollFirst();
            } else if (!s.equals(".") && !s.equals("")) {
                deque.offerFirst(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
            sb.append('/');
        }
        if(sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}