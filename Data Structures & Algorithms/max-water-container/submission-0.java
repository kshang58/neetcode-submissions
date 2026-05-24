class Solution {
    public int maxArea(int[] heights) {
        int globalMax = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            globalMax = Math.max(globalMax, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] <= heights[j]) {
                i ++;
            } else {
                j --;
            }
        }
        return globalMax;
    }
}
