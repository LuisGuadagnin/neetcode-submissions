class Solution {
    public int numDecodings(String s) {
        int[] results = new int[s.length() + 1];
        results[s.length()] = 1;
        for (int i = s.length() - 1; i >=0; i--) {
            char currChar = s.charAt(i);
            if (currChar == '0') {
                results[i] = 0;
            } else {
                results[i] = results[i+1];

                boolean isCombinationPossible = i != s.length() - 1
                        && (currChar == '1' || (currChar == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'));
                if (isCombinationPossible) {
                    results[i] += results[i + 2];
                }
            }            
        }
        return results[0];
    }
}
