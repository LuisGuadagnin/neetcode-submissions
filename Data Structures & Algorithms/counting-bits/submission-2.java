class Solution {

    private static Map<Integer, Integer> PRECOMPUTED = new HashMap<>();

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnesSingleNumber(i);
        }
        return result;
    }

    public int countOnesSingleNumber(int n) {
        if (n == 0) return 0;

        Integer precomputedResult = PRECOMPUTED.get(n);
        if (precomputedResult != null) {
            return precomputedResult;
        }

        int result = (n % 2) + countOnesSingleNumber(n/2);

        PRECOMPUTED.put(n, result);
        return result;
    }
}
