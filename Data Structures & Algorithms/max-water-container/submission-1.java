class Solution {
    public int maxArea(int[] heights) {

        int leftPointer = 0;
        int rightPointer = heights.length - 1;

        int maxArea = 0;
        while(leftPointer < rightPointer) {
            int leftHeight = heights[leftPointer];
            int rightHeight = heights[rightPointer];

            int height = Math.min(leftHeight, rightHeight);
            int width = rightPointer - leftPointer;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (leftHeight < rightHeight) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
