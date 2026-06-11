/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        List<Interval> intervalsSortedByStartTime = intervals
                .stream()
                .sorted((i1, i2) -> Integer.compare(i1.start, i2.start))
                .toList();
        for (int i = 1; i < intervals.size(); i++) {
            Interval previousInterval = intervalsSortedByStartTime.get(i - 1);
            Interval currentInterval = intervalsSortedByStartTime.get(i);

            if (currentInterval.start < previousInterval.end) {
                return false;
            }
        }
        return true;
    }
}
