class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        int tot = 0;
        while (left <= right) {
            maxL = Math.max(maxL, height[left]);
            maxR = Math.max(maxR, height[right]);
            int cur = Math.min(maxL, maxR);
            if (maxL <= maxR) {
                tot += (cur - height[left]);
                left ++;
            } else {
                tot += (cur - height[right]);
                right --;
            }
        }
        return tot;
    }
}
