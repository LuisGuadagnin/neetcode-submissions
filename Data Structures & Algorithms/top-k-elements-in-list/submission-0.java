class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequency ++;
            frequencyMap.put(num, frequency);
        }
        List<Integer> sortedByFrequency = frequencyMap.entrySet().stream().sorted((entry1, entry2) -> {
            return entry2.getValue().compareTo(entry1.getValue());
        }).map(entry -> entry.getKey()).toList();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedByFrequency.get(i);
        }
        return result;
    }
}
