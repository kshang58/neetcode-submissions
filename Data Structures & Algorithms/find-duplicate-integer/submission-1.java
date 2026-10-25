class Solution {
    // 0 1 2 3 4 
    // 1 3 4 2 2
    // 0 -> 1 -> 3 -> 2 -> 4 -> 2
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pt = 0;
        while (pt != slow) {
            pt = nums[pt];
            slow = nums[slow];
        }
        return pt;
    }
}