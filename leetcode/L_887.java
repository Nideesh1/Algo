class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        int m = 0;
        while(dp[m][K] < N){
            m++;
            for(int k = 1; k <= K; k++){
                dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1;
            } 
        }
        return m;
    }
}

//https://leetcode.com/problems/super-egg-drop/discuss/158974/C%2B%2BJavaPython-2D-and-1D-DP-O(KlogN)
