class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        int[] prodRev = new int[n];
        int[] rslt = new int[n];
        for (int i = 0; i < n; i ++) {
            prod[i] = i == 0 ? nums[i] : prod[i - 1] * nums[i];
            prodRev[n - 1 - i] = i == 0 ? nums[n - 1] : prodRev[n - i] * nums[n - 1 - i];
        }
        rslt[0] = prodRev[1];
        rslt[n - 1] = prod[n - 2];
        for (int i = 1; i < n - 1; i ++) {
            rslt[i] = prod[i - 1] * prodRev[i + 1];
        }
        return rslt;
    }
}  
