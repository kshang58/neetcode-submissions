class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxL = height[0];
        int maxR = height[n - 1];
        int l = 1;
        int r = n - 2;
        int tot = 0;
        while (l <= r) {
            if (maxL > maxR) {
                tot += maxR - height[r] > 0 ? maxR - height[r] : 0;
                maxR = Math.max(maxR, height[r]);
                r --;
            } else {
                tot += maxL - height[l] > 0 ? maxL - height[l] : 0;
                maxL = Math.max(maxL, height[l]);
                l ++;
            }
        }
        return tot;
    }
}
