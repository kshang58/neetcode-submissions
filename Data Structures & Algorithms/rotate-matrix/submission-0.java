class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int offset = 0;
        int level = n / 2;
        while (offset < level) {
            int curL = offset;
            int curR = n - 1 - offset;
            int curT = offset;
            int curB = n - 1 - offset;
            int[] temp = new int[curR - curL];
            // store the first row to temp list
            for (int i = curL; i < curR; i ++) {
                temp[i - curL] = matrix[curT][i];
            }
            // move the left col part to top row
            for (int i = curB; i > curT; i --) {
                matrix[curT][curL + curR - i] = matrix[i][curL];
            }
            // move the bottom row part to left col
            for (int i = curR; i > curL; i --) {
                matrix[i][curL] = matrix[curB][i];
            }
            // move the right col part to bottom row
            for (int i = curT; i < curB; i ++) {
                matrix[curB][curR - (i - curL)] = matrix[i][curR];
            }
            // move the temp part to right col
            for (int i = curL; i < curR; i ++) {
                matrix[i][curR] = temp[i - curL];
            }
            offset ++;
        }
    }
}
