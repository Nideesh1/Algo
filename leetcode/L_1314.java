class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] + mat[i][j] - dp[i][j];
            }
        }
        
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                int r1 = Math.max(0, i - K);
                int c1 = Math.max(0, j - K);
                int r2 = Math.min(m, i + K + 1);
                int c2 = Math.min(n, j + K + 1);
                
                res[i][j] = dp[r2][c2] + dp[r1][c1] - dp[r1][c2]  - dp[r2][c1];
                
            }
        }
        
        return res;
    }
}

//https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
