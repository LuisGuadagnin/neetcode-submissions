class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";

        /* Evaluates all palindromes with odd size (has center) */
        for (int palindromeCenter = 0; palindromeCenter < s.length(); palindromeCenter++) {
            String longestLocalPalindrome = expandPalindrome(s, palindromeCenter, palindromeCenter);
            if (longestLocalPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = longestLocalPalindrome;
            }
        }

        /* Evaluates all palindromes with even size (center is a pair of equal characters) */
        for (int pairEnd = 1; pairEnd < s.length(); pairEnd++) {
            if (s.charAt(pairEnd) == s.charAt(pairEnd-1)) {
                String longestLocalPalindrome = expandPalindrome(s, pairEnd - 1, pairEnd);
                if (longestLocalPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = longestLocalPalindrome;
                }
            }
        }

        return longestPalindrome;
    }

    public String expandPalindrome(String originalString, int start, int end /*inclusive*/) {
        LinkedList<Character> palindromeAsList = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            palindromeAsList.addLast(originalString.charAt(i));
        }

        for (int i = 1; start - i >= 0 && end + i < originalString.length(); i++) {
            char leftChar = originalString.charAt(start - i);
            char rightChar = originalString.charAt(end + i);
            if (leftChar == rightChar) {
                palindromeAsList.addFirst(leftChar);
                palindromeAsList.addLast(rightChar);
            } else {
                break;
            }
        }

        return palindromeAsList.stream().map(c -> c.toString()).collect(Collectors.joining());
    }
}
