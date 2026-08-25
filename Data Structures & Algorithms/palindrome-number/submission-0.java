class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        long temp = x;
        long rev = 0;
        while (temp > 0) {
            long n = temp % 10;
            rev = rev * 10 + n;
            temp = temp / 10;
        }
        return rev == x;
    }
}