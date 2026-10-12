class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, globalMax = 0;
        while (l < r) {
            if (heights[l] <= heights[r]) {
                globalMax = Math.max(globalMax, heights[l] * (r - l));
                l ++;
            } else {
                globalMax = Math.max(globalMax, heights[r] * (r - l));
                r --;
            }
        }
        return globalMax;
    }
}
