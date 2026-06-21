class Solution {

    record Pair(int a, int b) {}

    private boolean isPalindrome(String s, int startIndex, int endIndex, Map<Pair, Boolean> evaluatedSubstrings) {
        if (startIndex >= endIndex) {
            return true; 
        }
        
        Pair pair = new Pair(startIndex, endIndex);
        Boolean previousResult = evaluatedSubstrings.get(pair);
        if (previousResult != null) return previousResult;

        char left = s.charAt(startIndex);
        char right = s.charAt(endIndex);
        if (left != right) {
            evaluatedSubstrings.put(pair, false);
            return false;
        }
        boolean result = isPalindrome(s, startIndex + 1, endIndex - 1, evaluatedSubstrings);
        evaluatedSubstrings.put(pair, result);
        return result;
    }

    public int countSubstrings(String s) {
        Map<Pair, Boolean> evaluatedSubstrings = new HashMap<Pair, Boolean>();

        int amountOfPalindromes = 0;
        for (int size = 1; size <= s.length(); size++) {
            for (int i = 0; i < s.length() - size + 1; i++) {
                if (isPalindrome(s, i, i + size - 1, evaluatedSubstrings)) {
                    amountOfPalindromes++;
                }
            }
        }
        return amountOfPalindromes;
    }
}
