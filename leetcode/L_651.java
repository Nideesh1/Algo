class Solution {
    public int maxA(int N) {
        if(N < 7) return N;
        int[] dp = new int[N+1];
        dp[1] = 1; dp[2] = 2; dp[3] = 3; dp[4] = 4; dp[5] = 5; dp[6] = 6;
        
        for(int i = 7; i <= N; i++){

            int max = Integer.MIN_VALUE;
            
            for(int j = i -3; j >= 1; j--){
            
                max = Math.max(max, dp[j] * (i-j-1));
                
            }            
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        return dp[N];
    }
}

//https://leetcode.com/problems/4-keys-keyboard/
