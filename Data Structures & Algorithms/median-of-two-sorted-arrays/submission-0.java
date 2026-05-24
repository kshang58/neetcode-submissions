class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1 2 5 6 7 8
        // 3 4 6 8 10 12 find 6 and 7
        // 6 7 8
        // 3 4 6 8 10 12 find 3 and 4
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;
        if (A.length > B.length) {
            int[] temp = B;
            B = A;
            A = temp;
        }
        int l = 0;
        int r = A.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int j = half - m;
            int Aleft = m > 0 ? A[m - 1] : Integer.MIN_VALUE;
            int Aright = m < A.length ? A[m] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;
            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                } 
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
