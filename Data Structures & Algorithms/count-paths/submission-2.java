class Solution {
    public int uniquePaths(int m, int n) {

        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j>=0; j--) {
                row[j] = row[j+1] + row[j];
            }
        }
        return row[0];
    }
}
