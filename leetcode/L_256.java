class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length; 
        if(m == 0) return 0;
        int n = costs[0].length;
        
        int[][] dp = new int[m][n];
        dp[0] = costs[0];
        
        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < costs[i].length; k++){
                    if(k == j) continue;
                    min = Math.min(dp[i-1][k], min);
                }
                //System.out.println("For row i min is " + i + " " + min);
                dp[i][j] = min + costs[i][j];
            }
        }
        
        
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        int res = Integer.MAX_VALUE;
        for(int i : dp[m-1]){
            res = Math.min(res, i);
        }
        return res;
    } 
}

//https://leetcode.com/problems/paint-house/
