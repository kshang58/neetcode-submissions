class Solution {
    // 1 0 1 2 1 6
    // 1 1 1 2 3 5
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int[] m = new int[c.length + 1];
        if(c.length == 0 || c[0] == '0') {
            return 0;
        }
        m[0] = 1;
        m[1] = 1;
        for(int i = 2; i <= c.length; i ++) {
            if (c[i - 1] == '0') {
                if ((c[i - 2] != '1') && (c[i - 2] != '2')) {
                    return 0;
                } else {
                    m[i] = m[i - 2];
                    continue;
                }
            }
            int twoDigit = c[i - 1] - '0' + (c[i - 2] - '0') * 10;
            if (twoDigit <= 26 && twoDigit >= 10) {
                m[i] = m[i - 1] + m[i - 2];
            } else {
                m[i] = m[i - 1];
            }
        }
        return m[c.length];
    }
}
