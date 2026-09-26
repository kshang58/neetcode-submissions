class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i ++) {
            while(!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                map.put(stack.pollFirst(), nums2[i]);
            }
            stack.offerFirst(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i ++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}