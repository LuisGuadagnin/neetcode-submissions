class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start /*inclusive*/, int end /*exclusive*/) {
        System.out.printf("Searching between %d and %d\n", start, end);
        if (start == end - 1) {
            if (nums[start] != target) return -1;
            else return start;
        }
        
        int pivotPos = (start + end) / 2;
        int numStart = nums[start];
        int numEnd = nums[end-1];
        int numPivot = nums[pivotPos];

        if (numStart <= numPivot) { /* start-> pivot is ordered*/
            System.out.printf("numStart %d <= numPivot %d\n", numStart, numPivot);
            if (numStart <= target && target < numPivot) {
                // search again in first half
                System.out.printf("numStart %d <= target %d && target %d <= numPivot %d\n", numStart, target, target, numPivot);
                return search(nums, target, start, pivotPos);
            } else {
                // search again in second half
                return search(nums, target, pivotPos, end);
            }
        } else if (numPivot <= numEnd) {/* pivot -> end is ordered */
            if (numPivot <= target && target <= numEnd) {
                // search again in second half
                return search(nums, target, pivotPos, end);
            } else {
                // search again in first half
                return search(nums, target, start, pivotPos);
            }
        } else {
            throw new IllegalStateException("Array is not rotated sorted");
        }
        
    }
}
