class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        int[] prodRev = new int[nums.length];
        int[] rslt = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            prod[i] = i > 0 ? prod[i - 1] * nums[i] : nums[i];
            prodRev[nums.length - i - 1] = i > 0 ? prodRev[nums.length - i] * nums[nums.length - i - 1] : nums[nums.length - i - 1];
        }
        rslt[0] = prodRev[1];
        rslt[nums.length - 1] = prod[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i ++) {
            rslt[i] = prod[i - 1] * prodRev[i + 1];
        }
        return rslt;
    }
}  
