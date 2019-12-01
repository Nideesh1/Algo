class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = obstacleGrid;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        
        if(dp[0][0] == 1) return 0;
        
        dp[0][0] = 1;
        for(int i = 1; i < r; i++){
            dp[i][0] = (dp[i][0] == 0) && dp[i-1][0] == 1 ? 1 : 0;
        }
        
        for(int j = 1; j < c; j++){
            dp[0][j] = (dp[0][j] == 0) && dp[0][j-1] == 1 ? 1 : 0;
        }
        
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(dp[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[r-1][c-1];
    }
}

//https://leetcode.com/problems/unique-paths-ii/solution/
