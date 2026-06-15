class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnesSingleNumber(i);
        }
        return result;
    }

    public int countOnesSingleNumber(int n) {
        if (n == 0) return 0;

        return (n % 2) + countOnesSingleNumber(n/2);
    }
}
