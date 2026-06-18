class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startsAt = 0;
        Map<Character, Integer> lastOccurences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            Integer previousOccurence = lastOccurences.get(currChar);

            lastOccurences.put(currChar, i);
            if (previousOccurence != null && previousOccurence >= startsAt) {
                startsAt = previousOccurence + 1;
            }
            int currLength = i + 1 - startsAt;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;

    }
}
