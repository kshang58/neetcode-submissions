class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new int[]{i, i});
            } else {
                map.get(arr[i])[1] = i;
            }
        }
        List<int[]> valueList = new ArrayList<>(map.values());
        valueList.sort((a, b) -> Integer.compare(a[0], b[0]));
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] interval : valueList) {
            if (deque.isEmpty()) {
                deque.offerFirst(interval);
            } else {
                int[] top = deque.peekFirst();
                if (top[1] > interval[0]) {
                    deque.pollFirst();
                    interval[0] = top[0];
                    interval[1] = Math.max(top[1], interval[1]);
                }
                deque.offerFirst(interval);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            int[] pop = deque.pollLast();
            result.add(pop[1] - pop[0] + 1);
        }
        return result;
    }
}