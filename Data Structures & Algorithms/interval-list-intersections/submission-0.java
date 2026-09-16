class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0) {
            return firstList;
        } else if (secondList.length == 0) {
            return secondList;
        }
        int i = 0;
        int j = 0;
        List<int[]> rslt = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] cur1 = firstList[i];
            int[] cur2 = secondList[j];
            if (cur1[0] <= cur2[1] && cur2[0] <= cur1[1]) {
                int[] cur = new int[]{Math.max(cur1[0], cur2[0]), Math.min(cur1[1], cur2[1])};
                rslt.add(cur);
            }
            if (cur1[1] >= cur2[1]) {
                j ++;
            } else {
                i ++;
            }
        }
        return rslt.toArray(new int[rslt.size()][]);
    }
}