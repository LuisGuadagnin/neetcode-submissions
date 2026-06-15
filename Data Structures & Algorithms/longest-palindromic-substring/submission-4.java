class Solution {
    record PalindromeRef(String originalString, int start, int end /*inclusive*/) {
        public int length() {
            return end - start + 1;
        }

        public String palindromeAsString() {
            return originalString.substring(start, end + 1);
        }
    }

    public String longestPalindrome(String s) {
        PalindromeRef longestPalindrome = new PalindromeRef(s, 0, 0);

        /* Evaluates all palindromes with odd size (has center) */
        for (int palindromeCenter = 0; palindromeCenter < s.length(); palindromeCenter++) {
            PalindromeRef longestLocalPalindrome = expandPalindrome(new PalindromeRef(s, palindromeCenter, palindromeCenter));
            if (longestLocalPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = longestLocalPalindrome;
            }
        }

        /* Evaluates all palindromes with even size (center is a pair of equal characters) */
        for (int pairEnd = 1; pairEnd < s.length(); pairEnd++) {
            if (s.charAt(pairEnd) == s.charAt(pairEnd-1)) {
                PalindromeRef longestLocalPalindrome = expandPalindrome(new PalindromeRef(s, pairEnd - 1, pairEnd));
                if (longestLocalPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = longestLocalPalindrome;
                }
            }
        }

        return longestPalindrome.palindromeAsString();
    }

    public PalindromeRef expandPalindrome(PalindromeRef palindrome) {
        int i;
        for (i = 1; palindrome.start() - i >= 0 && palindrome.end() + i < palindrome.originalString().length(); i++) {
            char leftChar = palindrome.originalString().charAt(palindrome.start() - i);
            char rightChar = palindrome.originalString().charAt(palindrome.end() + i);
            if (leftChar != rightChar) {
                break;
            }
        }
        return new PalindromeRef(palindrome.originalString(), palindrome.start() - i + 1, palindrome.end() + i - 1);
    }
}
