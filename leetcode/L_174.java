class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        
        for(int i = m - 2; i >= 0; i--){
            dp[i][n-1] = Math.max(1,  dp[i+1][n-1] - dungeon[i][n-1]);
        }
        
        for(int j = n - 2; j >= 0; j--){
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        }
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                int down = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                int right = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                
                dp[i][j] = Math.min(down, right);
            }
        }
        
        return dp[0][0];
    }
}

//https://leetcode.com/problems/dungeon-game/discuss/52790/My-AC-Java-Version-Suggestions-are-welcome
