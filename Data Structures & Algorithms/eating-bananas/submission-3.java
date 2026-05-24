class Solution {
    private int timeNeeded(int[] piles, int k) {
        int tot = 0;
        for (int i : piles) {
            tot += i / k;
            if (i % k != 0) {
                tot += 1;
            }
        }
        return tot;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int p : piles) {
            if (p > r) {
                r = p;
            }
        }
        int l = 1;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            int num = timeNeeded(piles, m);
            if (num > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (timeNeeded(piles, l) <= h) {
            return l;
        } else {
            return r;
        }
    }
}
