class Solution {
    record Location(char c, int pos) {}

    public String minWindow(String s, String t) {
        
        Map<Character, Integer> requirements = t.chars()
                .boxed()
                .map(i -> (char) i.intValue())
                .collect(Collectors.toMap(
                    c -> c,
                    c -> 1,
                    (count1, count2) -> count1 + count2
                ));

        Map<Character, Integer> actualCount = requirements.keySet().stream()
                .collect(Collectors.toMap(
                    c -> c,
                    c -> 0
                ));

        int fulfilledRequirementCount = 0;
        
        int windowStart = 0;
        int windowEnd = 0;

        int shortestWindowStart = -1;
        int shortestWindowEnd = 1001;

        boolean canExpand = true;
        
        while(canExpand) {

            // expand window until valid condition
            while (windowEnd < s.length()) {
                char newChar = s.charAt(windowEnd);
                windowEnd++;
                if (requirements.containsKey(newChar)) {
                    Integer count = actualCount.get(newChar);
                    Integer requires = requirements.get(newChar);
                    if (count + 1 == requires) fulfilledRequirementCount++;
                    count++;
                    actualCount.put(newChar, count);

                    if (fulfilledRequirementCount == requirements.size()) {
                        if (shortestWindowEnd - shortestWindowStart > windowEnd - windowStart) {
                            shortestWindowEnd = windowEnd;
                            shortestWindowStart = windowStart;
                        }
                        break;
                    }
                }
            }
            if (windowEnd == s.length()) canExpand = false;

            //shrink window until invalid condition
            while (fulfilledRequirementCount == requirements.size()) {
                char poppedChar = s.charAt(windowStart);
                windowStart ++;

                if (requirements.containsKey(poppedChar)) {
                    Integer count = actualCount.get(poppedChar);
                    Integer requires = requirements.get(poppedChar);
                    count--;
                    actualCount.put(poppedChar, count);
                    if (count < requires) {
                        fulfilledRequirementCount--;
                        break;
                    }
                }

                if (shortestWindowEnd - shortestWindowStart > windowEnd - windowStart) {
                    shortestWindowEnd = windowEnd;
                    shortestWindowStart = windowStart;
                }
            }
        }   
        if (shortestWindowStart == -1) return "";
        return s.substring(shortestWindowStart, shortestWindowEnd);     
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