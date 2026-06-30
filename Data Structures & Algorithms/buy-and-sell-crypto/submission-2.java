class Solution {
    public int maxProfit(int[] prices) {
        int[] minBefore = new int[prices.length];
        int[] maxAfter = new int[prices.length];

        minBefore[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBefore[i] = Math.min(minBefore[i-1], prices[i]);
        } 

        maxAfter[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxAfter[i] = Math.max(maxAfter[i+1], prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currProfit = maxAfter[i] - minBefore[i];
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
