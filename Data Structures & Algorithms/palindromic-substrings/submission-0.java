class Solution {

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            char left = s.charAt(startIndex);
            char right = s.charAt(endIndex);
            if (left != right) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int amountOfPalindromes = 0;
        for (int size = 1; size <= s.length(); size++) {
            for (int i = 0; i < s.length() - size + 1; i++) {
                if (isPalindrome(s, i, i + size - 1)) {
                    amountOfPalindromes++;
                }
            }
        }
        return amountOfPalindromes;
    }
}
