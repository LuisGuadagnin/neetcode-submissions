class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length);
    }

    public int findMin(int[] nums, int startIndex, int endIndex) {
        int start = nums[startIndex];
        int end = nums[endIndex - 1];
        int middleIndex = (startIndex + endIndex)/2;
        int middle = nums[middleIndex];

        if (startIndex >= endIndex - 1) return start;
        if (start < end) return start;
        if (start > middle) {
            return findMin(nums, startIndex + 1, middleIndex + 1);
        } else {
            return findMin(nums, middleIndex + 1, endIndex);
        }
    }
}
