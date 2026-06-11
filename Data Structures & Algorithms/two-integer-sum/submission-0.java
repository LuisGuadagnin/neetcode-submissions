class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numPositions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            Integer complementPosition = numPositions.get(complement);
            if (complementPosition != null) {
                return new int[] { complementPosition, i };
            }

            numPositions.put(num, i);
        }
        return null;
    }
}
