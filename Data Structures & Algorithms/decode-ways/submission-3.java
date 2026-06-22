class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memoizedIndexes = new HashMap<>();
        return numDecodings(s, 0, memoizedIndexes);
    }

    private int numDecodings(String s, int index, Map<Integer, Integer> memoizedIndexes) {
        if (s.length() == index) return 1;

        char currChar = s.charAt(index);
        if (currChar == '0') return 0;

        Integer previousResult = memoizedIndexes.get(index);
        if (previousResult != null) {
            return previousResult;
        }

        int result = numDecodings(s, index + 1, memoizedIndexes);

        if (index < s.length() - 1) {
            char nextChar = s.charAt(index + 1);
            if (currChar == '1' || (currChar == '2' && nextChar >= '0' && nextChar <= '6')) {
                result += numDecodings(s, index + 2, memoizedIndexes);
            }
        }

        memoizedIndexes.put(index, result);
        return result;
    }
}
