class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int maxProduct = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num == 0) {
                currMax = 0;
                currMin = 0;
            } else {
                if (currMax == 0) {
                    currMax = 1;
                    currMin = 1;
                }
                int previousMax = currMax;
                int previousMin = currMin;

                currMax = Math.max(num, Math.max(previousMax * num, previousMin * num));
                currMin = Math.min(num, Math.min(previousMax * num, previousMin * num));
            }

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
