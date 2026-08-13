class Solution {
    public int candy(int[] ratings) {
        // 4,3,5,2,3,4,4
        // 2,1,2,1,2,3,1
        int n = ratings.length;
        int cad = n;
        int i = 1;
        while (i < n) {
            while (i < n && ratings[i] == ratings[i - 1]) {
                i ++;
                continue;
            }
            int inc = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                inc ++;
                cad += inc;
                i ++;
            }
            int dec = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                dec ++;
                cad += dec;
                i ++;
            }
            cad -= Math.min(inc, dec);
        }
        return cad;
    }
}