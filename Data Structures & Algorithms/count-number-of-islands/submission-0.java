class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean newIslandFound = checkIsland(grid, i, j);
                if (newIslandFound) islands ++;
            }
        }
        return islands;
    }

    private boolean checkIsland(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length
                || column < 0 || column >= grid[row].length) {
            return false;
        }

        char currentChar = grid[row][column];
        if (currentChar == '0') return false;

        grid[row][column] = '0';
        checkIsland(grid, row - 1, column);
        checkIsland(grid, row + 1, column);
        checkIsland(grid, row, column - 1);
        checkIsland(grid, row, column + 1);
        return true;
    }
}
