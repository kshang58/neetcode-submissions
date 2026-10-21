class Solution {
    // 1 0 0 
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int m = flowerbed.length;
        int i = 0;
        while (i < m) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == m - 1 || flowerbed[i + 1] == 0)) {
                i = i + 2;
                n --;
                if (n == 0) return true;
            } else {
                i = i + 1;
            }
        }
        return n == 0;
    }
}