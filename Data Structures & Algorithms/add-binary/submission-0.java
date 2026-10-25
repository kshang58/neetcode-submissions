class Solution {
    public String addBinary(String a, String b) {
        int l = a.length() - 1, r = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l >= 0 || r >= 0 || carry > 0) {
            int left = l >= 0 ? a.charAt(l) - '0' : 0;
            int right = r >= 0 ? b.charAt(r) - '0': 0;
            int cur = (left + right + carry) % 2;
            carry = (left + right + carry) / 2;
            sb.append((char)(cur + '0'));
            l --;
            r --;
        }
        return sb.reverse().toString();
    }
}