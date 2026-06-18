class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /*
Map of last occurence:
abcdb

i=0
{
  a -> 0
}
startsAt: 0

i=1
{
  a -> 0
  b -> 1
}
startsAt: 0

...

i=4
currChar = b
{
  a -> 0
  b -> 1
  c -> 2
  d -> 3
}
startsAt: 0

saves longestString (i - startsAt)
b -> 1 (later than startsAt), so new startsAt = 2
{
  a -> 0
  b -> 4
  c -> 2
  d -> 3
}

        */
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
