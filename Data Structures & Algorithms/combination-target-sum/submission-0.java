class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> allResults = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> results = combinationSum(nums, target, 0, i);
            if (results != null) allResults.addAll(results);
        }
        return allResults;
    }

    private List<List<Integer>> combinationSum(int[] nums, int target, int currSum, int currPosition) {
        int sum = currSum + nums[currPosition];
        if (sum == target) return List.of(new ArrayList<>(List.of(nums[currPosition])));
        if (sum > target) return null;
        
        List<List<Integer>> allResults = new ArrayList<>();
        for(int i = currPosition; i < nums.length; i++) {
            List<List<Integer>> result = combinationSum(nums, target, sum, i);
            if (result != null) allResults.addAll(result);
        }
        if (allResults.isEmpty()) return null;

        for (List<Integer> result : allResults) {
            result.add(nums[currPosition]);
        }
        return allResults;
    }
}
