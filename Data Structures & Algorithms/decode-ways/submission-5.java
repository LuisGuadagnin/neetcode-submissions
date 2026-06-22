class Solution {
    public int numDecodings(String s) {
        int currResult = 0;
        int nextResult = 1;
        int nextNextResult = 1;
        for (int i = s.length() - 1; i >=0; i--) {
            char currChar = s.charAt(i);
            if (currChar == '0') {
                currResult = 0;
            } else {
                currResult = nextResult;

                boolean isCombinationPossible = i != s.length() - 1
                        && (currChar == '1' || (currChar == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'));
                if (isCombinationPossible) {
                    currResult += nextNextResult;
                }
            }
            nextNextResult = nextResult;
            nextResult = currResult;
        }
        return currResult;
    }
}
