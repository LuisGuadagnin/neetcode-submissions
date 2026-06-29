class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            int compare = Integer.compare(i1[0], i2[0]);
            if (compare == 0) compare = Integer.compare(i1[1], i2[1]);
            return compare;
        });

        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(new int[] { interval[0], interval[1] });
                continue;
            }

            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (interval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], interval[1]);
            } else {
                mergedIntervals.add(new int[] { interval[0], interval[1] });
            }
        }

        return mergedIntervals.toArray(new int[0][]);
    }
}
