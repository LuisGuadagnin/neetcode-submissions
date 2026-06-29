class Solution {
    public int maxProduct(int[] nums) {
        int product = 0;
        int earliestNegativeProduct = 0;
        int maxProduct = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num == 0) {
                product = 0;
                earliestNegativeProduct = 0;
                maxProduct = Math.max(maxProduct, product);
            } else {
                product = product == 0 ? num : product * num;
                if (product < 0 && earliestNegativeProduct < 0) {
                    maxProduct = Math.max(maxProduct, product/earliestNegativeProduct);
                } else {
                    maxProduct = Math.max(maxProduct, product);
                }

                if (num < 0 && earliestNegativeProduct == 0) {
                    earliestNegativeProduct = product;
                }
            }
        }

        return maxProduct;
    }
}

/*
[2,4,-3,5,-1,-8]

i = 0
p = 2

i = 1
p = 8

i = 2
en = -3
p = -3

i = 3
en = -3
p = 5

i = 4
p = 15

i = 5
p = 15 / -3 (en) * -8 = 40

*/