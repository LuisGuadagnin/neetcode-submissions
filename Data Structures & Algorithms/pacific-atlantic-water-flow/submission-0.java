class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] canFlowToPacific = new boolean[heights.length][];
        boolean[][] canFlowToAtlantic = new boolean[heights.length][];
        
        for (int i = 0; i < heights.length; i++) {
            canFlowToPacific[i] = new boolean[heights[i].length];
            canFlowToAtlantic[i] = new boolean[heights[i].length];
        }

        // fill first row for Pacific and last row for Atlantic
        for (int i = 0; i < heights[0].length; i++) {
            markAsTrueAndExpand(0, i, heights, canFlowToPacific);
            markAsTrueAndExpand(heights.length - 1, i, heights, canFlowToAtlantic);
        }
        // fill first column for Pacific and last row column Atlantic
        for (int i = 0; i < heights.length; i++) {
            markAsTrueAndExpand(i, 0, heights, canFlowToPacific);
            markAsTrueAndExpand(i, heights[0].length - 1, heights, canFlowToAtlantic);
        }

        List<List<Integer>> flowToBoth = new ArrayList<>();

        for (int row = 0; row < heights.length; row++) {
            for (int column = 0; column < heights[row].length; column++) {
                if (canFlowToAtlantic[row][column]
                        && canFlowToPacific[row][column]) {
                    flowToBoth.add(List.of(row, column));
                }
            }
        }

        return flowToBoth;
    }

    private void printBooleanMatrix(boolean[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + "  ");
            }
            System.out.println();
        }
    }

    private void markAsTrueAndExpand(int row, int column, int[][] heights, boolean[][] flowMatrix) {
        flowMatrix[row][column] = true;

        // left candidate: [row][column - 1]
        if (column - 1 >= 0 && !flowMatrix[row][column - 1]) {
            if (heights[row][column - 1] >= heights[row][column]) {
                markAsTrueAndExpand(row, column - 1, heights, flowMatrix);
            }
        }
        // right candidate: [row][column + 1]
        if (column + 1 < heights[row].length && !flowMatrix[row][column + 1]) {
            if (heights[row][column + 1] >= heights[row][column]) {
                markAsTrueAndExpand(row, column + 1, heights, flowMatrix);
            }
        }
        // top candidate: [row - 1][column]
        if (row - 1 >= 0 && !flowMatrix[row - 1][column]) {
            if (heights[row - 1][column] >= heights[row][column]) {
                markAsTrueAndExpand(row - 1, column, heights, flowMatrix);
            }
        }
        // bottom candidate: [row + 1][column]
        if (row + 1 < heights.length && !flowMatrix[row + 1][column]) {
            if (heights[row + 1][column] >= heights[row][column]) {
                markAsTrueAndExpand(row + 1, column, heights, flowMatrix);
            }
        }
        
    }
}
