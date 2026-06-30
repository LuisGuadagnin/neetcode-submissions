class Solution {
    record Location(char c, int pos) {}

    public String minWindow(String s, String t) {
        
        Map<Character, Integer> tIndexed = t.chars().boxed().map(i -> (char) i.intValue())
                .collect(Collectors.toMap(
                    c -> c,
                    c -> 1,
                    (count1, count2) -> count1 + count2
                ));
        System.out.println("tIndexed: " + tIndexed);

        List<Location> allLocations = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tIndexed.containsKey(c)) {
                allLocations.add(new Location(c, i));
            }
        }
        System.out.println("allLocations: " + allLocations);

        int shortestRangeStart = -1;
        int shortestRangeEnd = 1001;

        Map<Character, LinkedList<Integer>> latestLocations = new HashMap<>();
        int amountOfTAlreadyAdded = 0;
        for (Location location : allLocations) {
            LinkedList<Integer> locationsOfC = latestLocations.getOrDefault(location.c, new LinkedList<>());
            latestLocations.put(location.c, locationsOfC);
            locationsOfC.offerLast(location.pos);
            int amountNeededOfC = tIndexed.get(location.c);
            int actualAmountOfC = locationsOfC.size();
            if (actualAmountOfC > amountNeededOfC) {
                locationsOfC.pollFirst();
            } else {
                amountOfTAlreadyAdded++;
            }

            if (amountOfTAlreadyAdded == t.length()) {
                int earliestPosition = Integer.MAX_VALUE;
                int latestPosition = Integer.MIN_VALUE;
                for (LinkedList<Integer> positions : latestLocations.values()) {
                    earliestPosition = Math.min(earliestPosition, positions.peekFirst());
                    latestPosition = Math.max(latestPosition, positions.peekLast());
                }
                if (latestPosition - earliestPosition < shortestRangeEnd - shortestRangeStart) {
                    shortestRangeStart = earliestPosition;
                    shortestRangeEnd = latestPosition;
                }
            }
        }

        return shortestRangeStart == -1 ? "" :
                s.substring(shortestRangeStart, shortestRangeEnd + 1);

    }
}

/*

s = "OUZODYXAZV", t = "XYZ"

(Y, 4), (X, 6), (Z, 8), (Y, 9), (X, 16), (Z, 18)

map
 Y -> 9
 X -> 6
 Z -> 8

shortestRange = 4 -> 8
shortestRange = 6 -> 9
calculate shortestRange = O(t)

*/