class Solution {

    public int climbStairs(int n) {
        Integer[] results = new Integer[n+1];
        results[0] = 1;
        results[1] = 1;
        return climbStairs(n, results);
    }

    public int climbStairs(int n, Integer[] results) {
        Integer result = results[n];
        if (result == null) {
            result = climbStairs(n - 1, results) + climbStairs(n - 2, results);
            results[n] = result;
        }
        return result;
    }
}
