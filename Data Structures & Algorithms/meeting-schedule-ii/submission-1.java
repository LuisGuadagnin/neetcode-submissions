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
    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        PriorityQueue<Integer> minHeapOngoingMeetingEnds = new PriorityQueue<>();
        int maxAmountOfRooms = 0;
        for (Interval currMeeting : intervals) {
            
            // remove all meetings who have ended
            while(!minHeapOngoingMeetingEnds.isEmpty() && minHeapOngoingMeetingEnds.peek() <= currMeeting.start) {
                minHeapOngoingMeetingEnds.poll();
            }

            minHeapOngoingMeetingEnds.offer(currMeeting.end);
            maxAmountOfRooms = Math.max(maxAmountOfRooms, minHeapOngoingMeetingEnds.size());
        }
        return maxAmountOfRooms;
    }
}
