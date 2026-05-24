class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        int j = matrix[0].length;
        int l = 0;
        int r = i * j - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if (matrix[m / j][m % j] == target) {
                return true;
            } else if (matrix[m / j][m % j] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
