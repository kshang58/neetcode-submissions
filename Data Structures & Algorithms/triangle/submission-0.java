class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rslt = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i ++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);
            rslt = Integer.MAX_VALUE;
            for (int j = 0; j < row.size(); j ++) {
                int cur = row.get(j);
                if (j == 0) {
                    cur += lastRow.get(0);
                } else if (j == row.size() - 1) {
                    cur += lastRow.get(row.size() - 2);
                } else {
                    cur += Math.min(lastRow.get(j), lastRow.get(j - 1));
                }
                row.set(j, cur);
                if (i == triangle.size() - 1) {
                    rslt = Math.min(rslt, cur);
                }
            }
        }
        return rslt;
    }
}