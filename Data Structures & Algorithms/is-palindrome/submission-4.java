class Solution {
    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(array[left])) {
                left ++;
            } else if (!Character.isLetterOrDigit(array[right])) {
                right --;
            } else {
                if (Character.toLowerCase(array[right]) == Character.toLowerCase(array[left])) {
                    left ++;
                    right --;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
