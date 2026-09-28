class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        int m = l + (r - l) / 2;
        int[] left = mergeSort(nums, l, m);
        int[] right = mergeSort(nums, m + 1, r);
        return merge(left, right);
    }
    public int[] merge(int[] l, int[] r) {
        int[] result = new int[l.length + r.length];
        int i = 0, j = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
                result[i + j] = l[i];
                i ++;
            } else {
                result[i + j] = r[j];
                j ++;
            }
        }
        while (i < l.length) {
            result[i + j] = l[i];
            i ++;
        }
        while (j < r.length) {
            result[i + j] = r[j];
            j ++;
        }
        return result;
    }
}