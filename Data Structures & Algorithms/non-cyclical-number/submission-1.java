class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        while(true) {
            int happyN = happy(n);
            if (happyN == 1) {
                return true;
            }
            if (hs.contains(happyN)) {
                return false;
            }
            hs.add(happyN);
            n = happyN;
        }
    }
    private int happy(int n) {
        int rslt = 0;
        while(n > 0) {
            rslt += (n % 10) * (n % 10);
            n = n / 10;
        }
        return rslt;
    }
}
