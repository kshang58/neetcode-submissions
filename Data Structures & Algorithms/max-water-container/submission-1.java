class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int globalMax = 0;
        while (left < right) {
            int cur = (right - left) * Math.min(heights[left], heights[right]);
            globalMax = Math.max(globalMax, cur);
            if (heights[left] < heights[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return globalMax;
    }
}
