class Solution {
    public int uniquePaths(int m, int n) {

        int[] previousRow = new int[n];
        for (int i = 0; i < n; i++) {
            previousRow[i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            int[] currentRow = new int[n];
            currentRow[n-1] = 1;
            for (int j = n - 2; j>=0; j--) {
                currentRow[j] = currentRow[j+1] + previousRow[j];
            }
            previousRow = currentRow;
        }
        return previousRow[0];
    }
}
