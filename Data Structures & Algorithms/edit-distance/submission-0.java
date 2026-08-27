class Solution {
    public int minDistance(String word1, String word2) {
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        int l1 = word1Arr.length;
        int l2 = word2Arr.length;
        if (l1 == 0) {
            return l2;
        } else if (l2 == 0) {
            return l1;
        }
        int[][] m = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i ++) {
            m[i][0] = i;
        }
        for (int j = 1; j <= l2; j ++) {
            m[0][j] = j;
        }
        for (int i = 1; i <= l1; i ++) {
            for (int j = 1; j <= l2; j ++) {
                int cur = word1Arr[i - 1] == word2Arr[j - 1] ? 0 : 1;
                int r = cur + m[i - 1][j - 1];
                int a = 1 + m[i - 1][j];
                int d = 1 + m[i][j - 1];
                m[i][j] = Math.min(Math.min(r, a), d);
            }
        }
        return m[l1][l2];
    }
}
