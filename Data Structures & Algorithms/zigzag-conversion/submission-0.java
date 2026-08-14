class Solution {
    public String convert(String s, int numRows) {
        // 3 - 4 4 - 6 5 - 8
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int inc = 2 * numRows - 2;
        for (int r = 0; r < numRows; r ++) {
            for (int i = r; i < s.length(); i += inc) {
                sb.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 && i + inc - 2 * r < s.length()) {
                    sb.append(s.charAt(i + inc - 2 * r));
                }
            }
        }
        return sb.toString();
    }
}