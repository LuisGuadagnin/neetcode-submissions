class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
            rob(nums, 0, nums.length - 1),
            rob(nums, 1, nums.length)
        );
    }

    public int rob(int[] nums, int start, int end) {
        int currMax = 0;
        int previousMax = 0;
        for (int i = start; i < end; i++) {
            int temp = previousMax;
            previousMax = currMax;
            currMax = Math.max(previousMax, temp + nums[i]);
        }
        return currMax;
    }

}
