class Solution {

    record Position(int x, int y) {}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> orderedMatrix = new ArrayList<>();

        int startingX = 0;
        int startingY = 0;
        int endingX = matrix[0].length;
        int endingY = matrix.length;
        while (true) {
            
            if (startingX == endingX) return orderedMatrix;
            for (int x = startingX; x < endingX; x++) {
                orderedMatrix.add(matrix[startingY][x]);
            }

            if (startingY + 1 == endingY) return orderedMatrix;
            for (int y = startingY + 1; y < endingY; y++) {
                orderedMatrix.add(matrix[y][endingX - 1]);
            }

            if (endingX - 2 < startingX) return orderedMatrix;
            for (int x = endingX - 2; x >= startingX; x--) {
                orderedMatrix.add(matrix[endingY - 1][x]);
            }

            if (endingY - 2 == startingY) return orderedMatrix;
            for (int y = endingY - 2; y > startingY; y--) {
                orderedMatrix.add(matrix[y][startingX]);
            }

            startingX++;
            startingY++;
            endingX--;
            endingY--;
        }
    }
}
