class Solution {

    public int countSubstrings(String s) {
        int amountOfPalindromes = 0;

        for (int i = 0; i < s.length(); i++) {

            int leftPointer;
            int rightPointer;

            // verify palindromes with odd length
            amountOfPalindromes++; // add palindrome of size = 1
            leftPointer = i - 1;
            rightPointer = i + 1;
            while(leftPointer >= 0 && rightPointer < s.length()) {
                if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                    break;
                }
                leftPointer--;
                rightPointer++;
                amountOfPalindromes++;
            }

            // verify palindromes with even length
            leftPointer = i;
            rightPointer = i+1;
            while(leftPointer >= 0 && rightPointer < s.length()) {
                if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                    break;
                }
                leftPointer--;
                rightPointer++;
                amountOfPalindromes++;
            }

        }

        return amountOfPalindromes;
    }
}
