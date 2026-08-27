class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] m = new int[matrix.length][matrix[0].length];
        int globalMax = 0;
        for (int i = 0; i < matrix.length; i ++) {
            m[i][0] = matrix[i][0] == '0' ? 0: 1;
            globalMax = Math.max(globalMax, m[i][0]);
            for (int j = 1; j < matrix[0].length; j ++) {
                if (i == 0) {
                    m[i][j] = matrix[i][j] == '0' ? 0: 1;
                    globalMax = Math.max(globalMax, m[i][j]);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    m[i][j] = 0;
                } else {
                    m[i][j] = Math.min(Math.min(m[i - 1][j - 1], m[i - 1][j]), m[i][j - 1]) + 1;
                    globalMax = Math.max(globalMax, m[i][j]);
                }
            }
        }
        return globalMax * globalMax;
    }
}