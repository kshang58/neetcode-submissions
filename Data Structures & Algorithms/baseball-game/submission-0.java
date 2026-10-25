class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String o : operations) {
            if (o.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else if (o.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (o.equals("C")) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.parseInt(o));
            }
        }
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}