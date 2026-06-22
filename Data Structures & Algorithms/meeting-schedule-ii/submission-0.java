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
        Map<Integer, Integer> amountOfRoomsByHour = new HashMap<>();

        for (Interval interval : intervals) {
            for (int i = interval.start; i < interval.end; i++) {
                int amountOfRoomsForI = amountOfRoomsByHour.getOrDefault(i, 0);
                amountOfRoomsForI++;
                amountOfRoomsByHour.put(i, amountOfRoomsForI);
            }
        }

        int maxRooms = 0;
        for (Integer rooms : amountOfRoomsByHour.values()) {
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }
}
