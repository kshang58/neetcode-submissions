class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                left.offerFirst(i);
            } else if (s.charAt(i) == ')') {
                if (!left.isEmpty()) {
                    left.pollFirst();
                } else if (!star.isEmpty()) {
                    star.pollFirst();
                } else {
                    return false;
                }
            } else {
                star.offerFirst(i);
            }
        }
        while (!left.isEmpty()) {
            if (star.isEmpty()) return false;
            int leftPos = left.pollFirst();
            int starPos = star.pollFirst();
            if (starPos < leftPos) return false;
        }
        return true;
    }
}