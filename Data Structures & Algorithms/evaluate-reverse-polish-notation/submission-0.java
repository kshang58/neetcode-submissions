class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i ++) {
            if (isNumeric(tokens[i])) {
                stack.offerFirst(Integer.parseInt(tokens[i]));
            } else {
                Integer ele1 = stack.pollFirst();
                Integer ele2 = stack.pollFirst();
                if (tokens[i].equals("+")) {
                    stack.offerFirst(ele2 + ele1);
                }
                if (tokens[i].equals("-")) {
                    stack.offerFirst(ele2 - ele1);
                }
                if (tokens[i].equals("*")) {
                    stack.offerFirst(ele2 * ele1);
                }
                if (tokens[i].equals("/")) {
                    stack.offerFirst(ele2 / ele1);
                }
            }
        }
        return stack.pollFirst();
    }

    public static boolean isNumeric(String str) { 
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
}
