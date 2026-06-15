class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnesSingleNumber(i);
        }
        return result;
    }

    public int countOnesSingleNumber(int n) {
        int curr = n;
        int amountOfOnes = 0;
        while (curr > 0) {
            int mod = curr % 2;
            if (mod == 1) {
                amountOfOnes ++;
            }
            curr = curr / 2;
        }
        return amountOfOnes;
    }
}
