class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int r = x / 2;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if ((long)m * m > x) {
                r = m - 1;
            } else if ((long)m * m == x) {
                return m;
            } else {
                l = m;
            }
        }
        if ((long)r * r <= x) {
            return r;
        }
        return l;
    }
}