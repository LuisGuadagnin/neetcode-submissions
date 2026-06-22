class Solution {
    public int uniquePaths(int m, int n) {
        int[][] amountOfPaths = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j>=0; j--) {
                if (i == m-1 || j == n - 1) {
                    amountOfPaths[i][j] = 1;
                } else {
                    amountOfPaths[i][j] = amountOfPaths[i + 1][j] + amountOfPaths[i][j + 1];
                }
            }
        }
        return amountOfPaths[0][0];
    }
}
