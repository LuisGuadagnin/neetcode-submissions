class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequency ++;
            frequencyMap.put(num, frequency);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int resultIt = 0;
        for (int i = buckets.length - 1; i>=0; i--) {
            if (buckets[i] == null) continue;
            for (int num : buckets[i]) {
                result[resultIt++] = num;
                if (resultIt == k) return result;
            }
        }
        return result;
    }

    
}
