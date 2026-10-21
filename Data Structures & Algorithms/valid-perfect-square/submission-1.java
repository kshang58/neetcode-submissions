class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long l = 0L, r = num / 2;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sq = m * m;
            if (sq == num) return true;
            if (sq < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}