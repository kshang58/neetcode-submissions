class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int op = '+';
        int num = 0;
        for (int i = 0; i < arr.length; i ++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == arr.length - 1) {
                if (op == '+') {
                    stack.offerFirst(num);
                } else if (op == '-') {
                    stack.offerFirst(num * -1);
                } else if (op == '*') {
                    int num1 = stack.pollFirst();
                    stack.offerFirst(num * num1);
                } else {
                    int num1 = stack.pollFirst();
                    stack.offerFirst(num1 / num);
                }
                op = c;
                num = 0;
            }
        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}