class Solution {
    public double myPow(double x, int n) {
        return dfs(x,n);
    }
    public double dfs(double x, int n) {
        if (n == 0) return 1; 
        if (x == 0 || x == 1 || n == 1) return x;
        
        if (n < 0) {
            return (1/x) * dfs(1/x, -(n+1));
        }
        
        return n % 2 == 0 ? dfs(x*x, n /2) : x * dfs(x*x, n / 2);
    }
}
//https://leetcode.com/problems/powx-n/discuss/1515322/Java-or-TC%3A-O(logN)-or-Optimized-Recursive-and-Iterative-(handles-overflow)-solutions
