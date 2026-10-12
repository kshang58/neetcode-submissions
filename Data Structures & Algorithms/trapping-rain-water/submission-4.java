class Solution {
    public int trap(int[] height) {
        int l = 1, r = height.length - 2, total = 0, maxL = height[0], maxR = height[height.length - 1];
        while (l <= r) {
            if (maxL <= maxR) {
                total += (maxL - height[l]) > 0 ? (maxL - height[l]) : 0;
                maxL = Math.max(maxL, height[l]);
                l ++;
            } else {
                total += (maxR - height[r]) > 0 ? (maxR - height[r]) : 0;
                maxR = Math.max(maxR, height[r]);
                r --;
            }
        }
        return total;
    }
}
