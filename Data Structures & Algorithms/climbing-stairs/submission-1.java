class Solution {
    Map<Integer, Integer> nSteps = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        Integer result = nSteps.get(n);
        if (result == null) {
            result = climbStairs(n - 1) + climbStairs(n - 2);
            nSteps.put(n, result);
        }
        return result;
    }
}
