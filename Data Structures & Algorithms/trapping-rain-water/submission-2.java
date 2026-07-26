class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int MaxL = height[l];
        int MaxR = height[r];
        int sum = 0;
        while (l < r) {
            if (MaxL <= MaxR) {
                l ++;
                int trap = Math.min(MaxL, MaxR) - height[l];
                sum = sum + (trap > 0 ? trap : 0);
                MaxL = Math.max(MaxL, height[l]);
            } else {
                r --;
                int trap = Math.min(MaxL, MaxR) - height[r];
                sum = sum + (trap > 0 ? trap : 0);
                MaxR = Math.max(MaxR, height[r]);
            }

        }
        return sum;
    }
}
