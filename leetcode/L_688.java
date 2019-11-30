class Solution {
    public double knightProbability(int N, int K, int r, int c) {

        int[] x = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] y = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        
        double[][] dp0 = new double[N][N];
        for(double[] d : dp0) Arrays.fill(d, 1);
        
        for(int t = 0; t < K; t++){
            
            double[][] dp1 = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    
                    for(int k = 0; k < x.length; k++){
                        int ro = i + x[k];
                        int co = j + y[k];
                        
                        if(outside(ro,co,N))continue;
                        dp1[i][j] += dp0[ro][co]; 
                    }
                    
                }
            }
            dp0 = dp1;
        }
        
        return dp0[r][c] / Math.pow(8, K);
    }
    
    public boolean outside(int ro, int co, int N){
        if(ro < 0 || ro >= N || co < 0 || co >= N) return true;
        return false;
    }
    
    
}

//https://leetcode.com/problems/knight-probability-in-chessboard/solution/
