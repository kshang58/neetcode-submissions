class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rslt = new int[n];
        rslt[0] = 1;
        for (int i = 1; i < n; i ++) {
            rslt[i] = rslt[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i --) {
            rslt[i] = rslt[i] * postfix;
            postfix = postfix * nums[i];
        }
        return rslt;
    }
}  
