class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int globalMax = 0;
        while (l < r) {
            int lh = heights[l];
            int rh = heights[r];
            globalMax = Math.max(globalMax, Math.min(lh, rh) * (r - l));
            if (lh >= rh) {
                r --;
            } else {
                l ++;
            }
        }
        return globalMax;
    }
}
