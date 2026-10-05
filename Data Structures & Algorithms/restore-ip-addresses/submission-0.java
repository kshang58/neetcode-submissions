class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] arr = s.toCharArray();
        List<String> result = new ArrayList<>();
        if (arr.length < 4) return result;
        StringBuilder sb = new StringBuilder();
        dfs(arr, result, sb, 0, 4);
        return result;
    }
    private void dfs(char[] arr, List<String> result, StringBuilder sb, int index, int num) {
        if (index == arr.length && num == 0) {
            result.add(sb.toString());
            return;
        }
        if (index == arr.length || num == 0) return;
        StringBuilder cur = new StringBuilder();
        for (int i = index; i < Math.min(arr.length, index + 3); i ++) {
            cur.append(arr[i]);
            if (!isValid(cur.toString())) break;
            int oldLength = sb.length();
            if (sb.length() > 0) {
                sb.append('.');
            }
            sb.append(cur.toString());
            dfs(arr, result, sb, i + 1, num - 1);
            sb.setLength(oldLength);
        }
    }
    private boolean isValid(String s) {
        if (s.startsWith("0") && s.length() > 1) return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
}