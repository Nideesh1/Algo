class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k*k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for(int i = 2; i < n; i++){
            dp[i] = (k-1) * dp[i-1] + (k-1) * dp[i-2];
        }
        return dp[n-1];
    }
}

//https://leetcode.com/problems/paint-fence/
