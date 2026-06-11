class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> pastNums = new HashSet<>();

        for (int num : nums) {
            if (pastNums.contains(num)) {
                return true;
            }
            pastNums.add(num);
        }
        return false;
    }
}