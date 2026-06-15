class Solution {

    public int climbStairs(int n) {
        if (n == 0 || n ==1) return 1;

        int amountWalkingOne = 1;
        int amountWalkingTwo = 1;
        int amountPossibilities = 0;
        for (int i = 2; i<= n; i++) {
            amountPossibilities = amountWalkingOne + amountWalkingTwo;
            amountWalkingTwo = amountWalkingOne;
            amountWalkingOne = amountPossibilities;
        }
        return amountPossibilities;
    }
}
