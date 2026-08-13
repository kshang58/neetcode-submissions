class Solution {
    public int majorityElement(int[] nums) {
        int rslt = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                rslt = n;
            }
            if (rslt == n) {
                count ++;
            } else {
                count --;
            }
        }
        return rslt;
    }
}