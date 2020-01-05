class Solution {
        int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        
        return dfs(s.toCharArray(), 0, n - 1);
    }
    
    public int dfs(char[] arr, int i, int j){
        if( i >= j ) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(arr[i] == arr[j]){
            dp[i][j] =  dfs(arr, i + 1, j - 1);
            return dp[i][j];
        }
        
        
        int l = dfs(arr, i + 1, j);

        int r = dfs(arr, i, j - 1);

        
        dp[i][j] = Math.min(l, r) + 1;
        
        return dp[i][j];
    }
}

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/discuss/470698/Java-Small-code-with-Recursion-with-Memoization
