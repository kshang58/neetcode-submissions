class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] sol = new int[2];
        while(l < r) {
            if (numbers[r] == target - numbers[l]) {
                sol[0] = l + 1;
                sol[1] = r + 1;
                return sol;
            } else if (numbers[r] > target - numbers[l]) {
                r --;
            } else {
                l ++;
            }
        }
        return sol;
    }
}
