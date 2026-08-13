class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int pt1 = m - 1;
        int pt2 = n - 1;
        while (pt2 >= 0) {
            if (pt1 >= 0 && nums1[pt1] >= nums2[pt2]) {
                nums1[i] = nums1[pt1];
                pt1 --;
            } else {
                nums1[i] = nums2[pt2];
                pt2 --;
            }
            i --;
        }
    }
}