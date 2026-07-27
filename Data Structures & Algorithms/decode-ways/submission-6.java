class Solution {
    public int numDecodings(String s) {
        // 1 0 1 2 2 6 8 4
        // 1 1 1 2 3 5 5 5
        // 1 1
        // 1 2
        char[] c = s.toCharArray();
        int[] m = new int[c.length + 1];
        if (c.length == 0 || c[0] == '0') return 0;
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= c.length; i ++) {
            if (c[i - 1] == '0') {
                if (c[i - 2] == '1' || c[i - 2] == '2') {
                    m[i] = m[i - 2];
                } else {
                    return 0;
                }
            } else if (c[i - 2] == '0'){ 
                m[i] = m[i - 1];
            } else {
                if ((c[i - 2] - '0') * 10 + (c[i - 1] - '0') <= 26) {
                    m[i] = m[i - 1] + m[i - 2];
                } else {
                    m[i] = m[i - 1];
                }
            }
        }
        return m[c.length];
    }
}
