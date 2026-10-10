class Solution {
    public void rotate(int[][] matrix) {
        helper(matrix, matrix.length - 1, 0);
    }
    private void helper(int[][] matrix, int len, int offset) {
        if (len <= 0) {
            return;
        }
        int[] temp = new int[len];
        // store the top row into temp
        for (int i = 0; i < len; i ++) {
            temp[i] = matrix[offset][i + offset];
        }
        for (int i = 0; i < len; i ++) {
            matrix[offset][i + offset] = matrix[matrix.length - 1 - offset - i][offset];
        }
        for (int i = 0; i < len; i ++) {
            matrix[matrix.length - 1 - offset - i][offset] = matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i];
        }
        for (int i = 0; i < len; i ++) {
            matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i] = matrix[offset + i][matrix.length - 1 - offset];
        }
        for (int i = 0; i < len; i ++) {
            matrix[offset + i][matrix.length - 1 - offset] = temp[i];
        }
        helper(matrix, len - 2, offset + 1);
    }
}