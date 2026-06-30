class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> allResults = new ArrayList<>();
        combinationSum(nums, target, allResults, new ArrayList<>(), 0);
        return allResults;
    }

    private void combinationSum(int[] nums, int remaining, List<List<Integer>> results, List<Integer> currCombination, int start) {
        int currentNumber = nums[start];
        int newRemaining = remaining - currentNumber;
        if (newRemaining < 0) return;

        if (newRemaining == 0) {
            List<Integer> result = new ArrayList<>(currCombination);
            result.add(currentNumber);
            results.add(result);
            return;
        }

        currCombination.add(currentNumber);
        for (int i = start; i < nums.length; i++) {
            combinationSum(nums, newRemaining, results, currCombination, i);
        }
        currCombination.remove(currCombination.size() - 1);

        if (start + 1 < nums.length && currCombination.isEmpty())
            combinationSum(nums, remaining, results, currCombination, start + 1);
    }
}
