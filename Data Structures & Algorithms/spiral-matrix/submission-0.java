class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rslt = new ArrayList<>();
        int width = matrix[0].length;
        int height = matrix.length;
        int offset = 0;
        int level = (Math.min(width, height) + 1) / 2;
        while (offset < level) {
            int top = offset;
            int bottom = height - 1 - offset;
            int left = offset;
            int right = width - 1 - offset;
            // 只剩一行
            if (top == bottom) {
                for (int j = left; j <= right; j++) {
                    rslt.add(matrix[top][j]);
                }
                break;
            }

            // 只剩一列
            if (left == right) {
                for (int i = top; i <= bottom; i++) {
                    rslt.add(matrix[i][left]);
                }
                break;
            }
            for (int i = left; i < right; i ++) {
                rslt.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i ++) {
                rslt.add(matrix[i][right]);
            }
            for (int i = right; i > left; i --) {
                rslt.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i --) {
                rslt.add(matrix[i][left]);
            }
            offset ++;
        }
        //  5 5 5 5 5
        //  5 5 5 5 5
        //  5 5 5 5 5

        return rslt;
    }
}
