class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPriceSoFar = 101;

        for (int i = 0; i < prices.length; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            int currProfit = prices[i] - minPriceSoFar;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
