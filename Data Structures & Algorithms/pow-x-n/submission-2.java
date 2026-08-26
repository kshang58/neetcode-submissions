class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        double rslt = pow(x, Math.abs((long) n));
        return n >= 0 ? rslt : 1 / rslt;
    }
    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double a = pow(x, n / 2);
        if (n % 2 == 1) {
            return a * a * x;
        } else {
            return a * a;
        }
    }
}
