class Solution {

    public int climbStairs(int n) {
        if (n == 0 || n ==1) return 1;

        int waysAtMinus1 = 1;
        int waysAtMinus2 = 1;
        for (int i = 2; i<= n; i++) {
            int temp = waysAtMinus1 + waysAtMinus2;
            waysAtMinus2 = waysAtMinus1;
            waysAtMinus1 = temp;
        }
        return waysAtMinus1;
    }
}
