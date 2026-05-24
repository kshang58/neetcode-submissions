class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(String.valueOf(s.length()));
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> rslt = new ArrayList<>();
        char[] c = str.toCharArray();
        int i = 0;
        while (i < c.length) {
            int len = 0;
            int j = i;
            while (Character.isDigit(c[j])) {
                len = len * 10 + c[j] - '0';
                j ++;
            }
            i = j + 1;
            rslt.add(new String(c, i, len));
            i = i + len;
        }
        return rslt;
    }
}
