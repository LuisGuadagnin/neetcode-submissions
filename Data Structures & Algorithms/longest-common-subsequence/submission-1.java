class Solution {

    record Pair(int pointer1, int pointer2) {}

    public int longestCommonSubsequence(String text1, String text2) {
        Map<Pair, Integer> memoizedResults = new HashMap<>();
        return longestCommonSubsequence(text1, 0, text2, 0, memoizedResults);
    }


    private int longestCommonSubsequence(String text1, int pointer1, String text2, int pointer2, Map<Pair, Integer> memoizedResults) {
        if (pointer1 == text1.length()) return 0;
        if (pointer2 == text2.length()) return 0;

        Pair pointerPair = new Pair(pointer1, pointer2);
        Integer memoizedResult = memoizedResults.get(pointerPair);
        if (memoizedResult != null) return memoizedResult;

        char currChar1 = text1.charAt(pointer1);
        char currChar2 = text2.charAt(pointer2);

        int result;
        if (currChar1 == currChar2) {
            result = 1 + longestCommonSubsequence(text1, pointer1 + 1, text2, pointer2 + 1, memoizedResults);
        }
        else {
            int lengthSkipping1 = longestCommonSubsequence(text1, pointer1 + 1, text2, pointer2, memoizedResults);
            int lengthSkipping2 = longestCommonSubsequence(text1, pointer1, text2, pointer2 + 1, memoizedResults);
            result = Math.max(lengthSkipping1, lengthSkipping2);
        }
        memoizedResults.put(pointerPair, result);
        return result;
    }

/*
    (0, 0) -> (1, 0), (0, 1)

    (1, 0) -> (2, 0), (1, 1)
    (0, 1) -> (1, 1), (0, 2)

*/

}
