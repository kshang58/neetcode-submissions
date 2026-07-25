class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        int l = 1;
        int r = max;
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            int mh = hours(piles, m);
            if (mh > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (hours(piles, l) <= h) {
            return l;
        } else {
            return r;
        }
    }
    private int hours(int[] piles, int speed) {
        int sum = 0;
        for (int i : piles) {
            sum += i % speed == 0 ? i / speed : (i / speed) + 1;
        }
        return sum;
    }
}
