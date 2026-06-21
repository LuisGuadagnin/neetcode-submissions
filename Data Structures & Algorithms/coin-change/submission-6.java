class Solution {
    private static int SENTINEL_MIN_AMOUNT = 99999;

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memoizedResults = new HashMap<>();
        Arrays.sort(coins);
        int result = coinChange(coins, amount, memoizedResults);
        return result == SENTINEL_MIN_AMOUNT ? -1 : result;
    }

    public int coinChange(int[] coins, int amount, Map<Integer, Integer> memoizedResults) {
        if (amount == 0) return 0;

        Integer previousResult = memoizedResults.get(amount);
        if (previousResult != null) {
            return previousResult;
        }

        int minAmount = SENTINEL_MIN_AMOUNT;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            int leftAmount = amount - coin;
            if (leftAmount >= 0) {
                int coinCount = 1 + coinChange(coins, amount - coin, memoizedResults);
                minAmount = Math.min(minAmount, coinCount);
            }
        }

        memoizedResults.put(amount, minAmount);
        return minAmount;
    }
}
