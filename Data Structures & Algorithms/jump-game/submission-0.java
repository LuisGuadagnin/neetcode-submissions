class Solution {
    public boolean canJump(int[] nums) {
        int position = 0;
        while (position < nums.length - 1) {
            int maxJump = nums[position];
            int bestJump = -1;
            int reachOfBestJump = -1;
            for (int jump = 1; jump <= maxJump; jump++) {
                int positionAfterJump = position + jump;
                int reachOfJump = positionAfterJump + nums[positionAfterJump];
                if (reachOfJump >= nums.length - 1) {
                    return true;
                }
                if (reachOfJump > reachOfBestJump) {
                    reachOfBestJump = reachOfJump;
                    bestJump = jump;
                }
            }
            if (bestJump <= 0) return false;
            position += bestJump;
        }
        return true;
    }
}
