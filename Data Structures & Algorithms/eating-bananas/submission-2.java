class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles);
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            int time = calculateTime(piles, mid);
            if (time <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if(calculateTime(piles, left) <= h) {
            return left;
        } else {
            return right;
        }
    }
    private int calculateTime(int[] piles, int k) {
        int tot = 0;
        for (int i : piles) {
            tot += Math.ceilDiv(i, k);
        }
        return tot;
    }
    private int findMax(int[] n) {
        int max = n[0];
        for(int i : n) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
