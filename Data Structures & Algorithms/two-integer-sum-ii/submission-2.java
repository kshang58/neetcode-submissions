class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] rslt = new int [2];
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                rslt[0] = l + 1;
                rslt[1] = r + 1;
                return rslt;
            } else if (numbers[l] + numbers[r] > target) {
                r --;
            } else {
                l ++;
            }
        }
        return rslt;
    }
}
