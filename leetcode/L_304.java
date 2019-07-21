class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < n; j++){
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]; 
            }
        }
        for(int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int tot = dp[row2][col2];
        
        if(row1 > 0){
            tot -= dp[row1-1][col2];
        }
        if(col1 > 0){
            tot -= dp[row2][col1-1];
        }
        if(row1 > 0 && col1 > 0){
            tot += dp[row1-1][col1-1];
        }
        return tot;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
 
// https://leetcode.com/problems/range-sum-query-2d-immutable/
