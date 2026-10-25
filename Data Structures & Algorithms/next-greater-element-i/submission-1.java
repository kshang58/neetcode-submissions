class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> index = new HashMap<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i ++) {
            index.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i ++) {
            while (!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                int cur = stack.pollFirst();
                int idx = index.get(cur);
                result[idx] = nums2[i];
            }
            if (index.containsKey(nums2[i])) {
                stack.offerFirst(nums2[i]);
            }
        }
        return result;
    }
}