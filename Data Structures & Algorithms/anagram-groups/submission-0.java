class Solution {

    public Map<Integer, Integer> buildCharOccurenceMap(String s) {
        Map<Integer, Integer> charOccurenceMap = new HashMap<>();
        s.chars().forEach(sChar -> {
            int occurences = charOccurenceMap.getOrDefault(sChar, 0);
            occurences ++;
            charOccurenceMap.put(sChar, occurences);
        });
        return charOccurenceMap;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Integer, Integer>, List<String>> anagramGroups = new HashMap<>();
        for (String str: strs) {
            var occurenceMap = buildCharOccurenceMap(str);
            List<String> strAnagramList = anagramGroups.getOrDefault(occurenceMap, new ArrayList<>());
            strAnagramList.add(str);
            anagramGroups.put(occurenceMap, strAnagramList);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
