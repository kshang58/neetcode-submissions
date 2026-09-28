class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        List<Integer> rslt = new ArrayList<>();
        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            if (n1.contains(i)) {
                rslt.add(i);
                n1.remove(i);
            }
        }
        return rslt.stream().mapToInt(Integer::intValue).toArray();
    }
}