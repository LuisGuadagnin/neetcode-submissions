class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequency ++;
            frequencyMap.put(num, frequency);
        }
        List<List<Integer>> buckets = new ArrayList<>();
        buckets.add(new ArrayList<>());
        for (int num : nums) {
            buckets.add(new ArrayList<>());
        }
        for (int num : frequencyMap.keySet()) {
            buckets.get(frequencyMap.get(num)).add(num);
        }

        int[] result = new int[k];
        int resultIt = 0;
        for (int i = buckets.size() - 1; i>=0; i--) {
            for (int num : buckets.get(i)) {
                result[resultIt++] = num;
                if (resultIt == k) return result;
            }
        }
        return result;
    }

    
}
