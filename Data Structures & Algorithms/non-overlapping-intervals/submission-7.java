class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        Solution 1: check each interval against every other interval
        i1 -> check against i2, i3, i4, ....
           -> conflict? remove i1 and call recursively
        i2 -> check against i1, i3, i4, ...
        ...
        time complexity: O(n^2)
        space complecity: O(n) -> need to store every removed i

        Solution 2: sort intervals by start
        [[1,2],[2,4],[1,4]] -> [[1,2],[1,4],[2,4]]
        Only need to check n vs n+1
        -> remove n and keep checking
        -> remove n+1 and keep checking

        time complexity: O(n*logn)
        space complexity: O(n)
        */
        if (intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        return eraseOverlapIntervals(intervals, 0, 1);
    }

    private int eraseOverlapIntervals(int[][] intervals, int iInterval1, int iInterval2) {
        if (iInterval2 == intervals.length) return 0;

        int[] currInterval = intervals[iInterval1];
        int[] nextInterval = intervals[iInterval2];

        if (nextInterval[0] < currInterval[1]) { /*conflict*/
            if (currInterval[1] < nextInterval[1]) {
                return 1 + eraseOverlapIntervals(intervals, iInterval1, iInterval2 + 1);
            } else {
                return 1 + eraseOverlapIntervals(intervals, iInterval2, iInterval2 + 1);
            }
        } else {
            return eraseOverlapIntervals(intervals, iInterval2, iInterval2 + 1);
        }
    }
}
