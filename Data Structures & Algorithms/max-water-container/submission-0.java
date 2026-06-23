class Solution {
    public int maxArea(int[] heights) {

        Map<Integer, Integer> heightMinPosition = new HashMap<>();
        Map<Integer, Integer> heightMaxPosition = new HashMap<>();
        
        Set<Integer> addedHeights = new HashSet<Integer>();
        PriorityQueue<Integer> maxHeapHeights = new PriorityQueue<>((h1, h2) -> Integer.compare(h2, h1));

        for (int pos = 0; pos < heights.length; pos ++) {
            int currentHeight = heights[pos];

            if (!addedHeights.contains(currentHeight)) {
                maxHeapHeights.add(currentHeight);
                addedHeights.add(currentHeight);
            }

            Integer minPosition = heightMinPosition.get(currentHeight);
            if (minPosition == null) {
                heightMinPosition.put(currentHeight, pos);
            }

            heightMaxPosition.put(currentHeight, pos);
        }

        int previousMinPosition = heights.length;
        int previousMaxPosition = - 1;
        int maxArea = 0;

        while (!maxHeapHeights.isEmpty()) {
            int currentHeight = maxHeapHeights.poll();
            int minPosition = Math.min(previousMinPosition, heightMinPosition.get(currentHeight));
            int maxPosition = Math.max(previousMaxPosition, heightMaxPosition.get(currentHeight));
            int currentArea = (maxPosition - minPosition) * currentHeight;
            maxArea = Math.max(currentArea, maxArea);

            previousMinPosition = minPosition;
            previousMaxPosition = maxPosition;
        }

        return maxArea;
    }
}
