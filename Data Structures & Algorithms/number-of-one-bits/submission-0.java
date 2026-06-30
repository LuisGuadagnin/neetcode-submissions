class Solution {
    public int hammingWeight(int n) {
        int amountOfBits = 0;

        while (n != 0) {
            int rightmostBit = n & 1;
            amountOfBits += rightmostBit;
            n = n >> 1;
        }

        return amountOfBits;
    }
}
