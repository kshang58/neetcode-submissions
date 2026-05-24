class Solution {

    public static boolean isNumeric(String str) { 
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (isNumeric(s)) {
                stack.offerFirst(Integer.parseInt(s));
                continue;
            } else {
                if (s.equals("+")) {
                    int a = stack.pollFirst();
                    int b = stack.pollFirst();
                    stack.offerFirst(a + b);
                }
                if (s.equals("-")) {
                    int a = stack.pollFirst();
                    int b = stack.pollFirst();
                    stack.offerFirst(b - a);
                }
                if (s.equals("*")) {
                    int a = stack.pollFirst();
                    int b = stack.pollFirst();
                    stack.offerFirst(a * b);
                }
                if (s.equals("/")) {
                    int a = stack.pollFirst();
                    int b = stack.pollFirst();
                    stack.offerFirst(b / a);
                }
            }
        }
        return stack.pollFirst();
    }
}
