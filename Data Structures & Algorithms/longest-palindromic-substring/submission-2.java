class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int palindromeCenter = 0; palindromeCenter < s.length(); palindromeCenter++) {
            String currentPalindrome = Character.toString(s.charAt(palindromeCenter));
            if (currentPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = currentPalindrome;
            }
            for (int i = 1; palindromeCenter - i >= 0 && palindromeCenter + i < s.length(); i++) {
                char newCharToLeft = s.charAt(palindromeCenter - i);
                char newCharToRight = s.charAt(palindromeCenter + i);
                if (newCharToLeft == newCharToRight) {
                    currentPalindrome = newCharToLeft + currentPalindrome + newCharToLeft;
                    if (currentPalindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = currentPalindrome;
                    }
                }
                else {
                    break;
                }
            }
        }

        for (int pairEnd = 1; pairEnd < s.length(); pairEnd++) {
            if (s.charAt(pairEnd) == s.charAt(pairEnd-1)) {
                String currentPalindrome = Character.toString(s.charAt(pairEnd)) + Character.toString(s.charAt(pairEnd));
                if (currentPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = currentPalindrome;
                }
                for (int i = 1; pairEnd - 1 - i >= 0 && pairEnd + i < s.length(); i++) {
                    char newCharToLeft = s.charAt(pairEnd - 1 - i);
                    char newCharToRight = s.charAt(pairEnd + i);
                    if (newCharToLeft == newCharToRight) {
                        currentPalindrome = newCharToLeft + currentPalindrome + newCharToLeft;
                        if (currentPalindrome.length() > longestPalindrome.length()) {
                            longestPalindrome = currentPalindrome;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
