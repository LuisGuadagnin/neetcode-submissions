class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> sCharOccurenceMap = new HashMap<>();
        s.chars().forEach(sChar -> {
            int occurences = sCharOccurenceMap.getOrDefault(sChar, 0);
            occurences++;
            sCharOccurenceMap.put(sChar, occurences);
        });
        Map<Integer, Integer> tCharOccurenceMap = new HashMap<>();
        t.chars().forEach(tChar -> {
            int occurences = tCharOccurenceMap.getOrDefault(tChar, 0);
            occurences++;
            tCharOccurenceMap.put(tChar, occurences);
        });

        return sCharOccurenceMap.equals(tCharOccurenceMap);
    }
}
